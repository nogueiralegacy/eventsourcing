package com.github.nogueiralegacy.eventsourcing.domain;

public class Credito implements Evento {
    private final double valor;

    public Credito(double valor) {
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return valor;
    }
}
