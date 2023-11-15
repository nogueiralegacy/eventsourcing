package com.github.nogueiralegacy.eventsourcing.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ContaBancaria {
    private final String CPF;
    private Set<Evento> movimentacoes = new HashSet<>();

    public ContaBancaria(String CPF) {
        this.CPF = CPF;
    }

    public void creditar(double valor) {
        movimentacoes.add(new Credito(valor));
    }

    public void debitar(double valor) {
        movimentacoes.add(new Debito(valor));
    }

    public double getSaldo() {
        double saldo = 0.0;
        for (Evento evento : movimentacoes) {
            saldo += evento.getValor();
        }

        return saldo;
    }
}
