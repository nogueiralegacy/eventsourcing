package com.github.nogueiralegacy.eventsourcing.domain;

import java.time.Instant;

public class Debito implements Evento {
    private final String instante;
    private final double valor;

    private final String tipo;
    public Debito(double valor) {
        this.valor = valor;
        this.instante = Instant.now().toString();
        this.tipo = getClass().getSimpleName();
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getInstante(){
        return instante;
    }

    @Override
    public String getTipo(){
        return tipo;
    }
}
