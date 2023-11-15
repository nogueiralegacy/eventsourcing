package com.github.nogueiralegacy.eventsourcing.domain;

import java.time.Instant;

public interface Evento {
    double getValor();

    String getInstante();

    String getTipo();
}
