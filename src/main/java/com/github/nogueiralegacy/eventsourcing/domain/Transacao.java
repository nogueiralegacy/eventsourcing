package com.github.nogueiralegacy.eventsourcing.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant momento;
    @Transient
    private Evento evento;
    private OperacaoTipo operacaoTipo;

    protected Transacao() {}

    public Transacao(Evento evento) {
        this.momento = Instant.now();
        this.evento = evento;
        this.operacaoTipo = evento instanceof Credito ? OperacaoTipo.CREDITO : OperacaoTipo.DEBITO;
    }
}
