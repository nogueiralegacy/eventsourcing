package com.github.nogueiralegacy.eventsourcing.domain;

public enum OperacaoTipo {
    DEBITO("debito"),

    CREDITO("credito");

    private final String tipo;

    OperacaoTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
