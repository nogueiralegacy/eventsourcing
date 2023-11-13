package com.github.nogueiralegacy.eventsourcing.domain;

public class Debito implements Evento {
    private final double valor;

    public Debito(double valor) {
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return valor;
    }
}
