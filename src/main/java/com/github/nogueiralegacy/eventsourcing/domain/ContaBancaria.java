package com.github.nogueiralegacy.eventsourcing.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;


@Entity
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String CPF;
    @Column(nullable = true)
    private double saldo;
    @OneToMany
    @JoinColumn(name = "id_conta")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Transacao> transacoes = new HashSet<>();

    protected ContaBancaria() {}

    public ContaBancaria(String CPF) {
        this.CPF = CPF;
    }

    public void creditar(double valor) {
        transacoes.add(new Transacao(new Credito(valor)));
    }

    public void debitar(double valor) {
        transacoes.add(new Transacao(new Debito(valor)));
    }

    private double applyEvent(Evento evento, double saldo) {
        double resultado = 0;
        if (evento instanceof Credito) {
            resultado = saldo + evento.getValor();
        } else if (evento instanceof Debito) {
            resultado = saldo - evento.getValor();
        }

        return resultado;
    }

    public double getSaldo() {
        double saldoResultado = 0;
        for (Transacao transacao : transacoes) {
           saldoResultado += applyEvent(transacao.getEvento(), saldoResultado);
        }
        setSaldo(saldoResultado);
        return this.saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}
