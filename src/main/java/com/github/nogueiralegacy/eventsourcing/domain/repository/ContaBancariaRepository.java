package com.github.nogueiralegacy.eventsourcing.domain.repository;

import com.github.nogueiralegacy.eventsourcing.domain.ContaBancaria;

import java.util.Optional;

public interface ContaBancariaRepository {
    void save(ContaBancaria contaBancaria);

    Optional<ContaBancaria> findByCPF(String cpf);
}
