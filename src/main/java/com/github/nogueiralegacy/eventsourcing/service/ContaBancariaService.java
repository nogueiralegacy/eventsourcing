package com.github.nogueiralegacy.eventsourcing.service;

import com.github.nogueiralegacy.eventsourcing.domain.ContaBancaria;
import com.github.nogueiralegacy.eventsourcing.domain.repository.ContaBancariaRepository;
import com.github.nogueiralegacy.eventsourcing.persistencia.ContaBancariaRepositoryJSON;

import java.util.Optional;

public class ContaBancariaService {
    private ContaBancariaRepository contaBancariaRepository;

    public void save(ContaBancaria contaBancaria) {
        contaBancariaRepository = new ContaBancariaRepositoryJSON();

        contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria findByCPF(String cpf) {
        contaBancariaRepository = new ContaBancariaRepositoryJSON();

        Optional<ContaBancaria> contaBancaria = contaBancariaRepository.findByCPF(cpf);
        if (contaBancaria.isPresent()) {
            return contaBancaria.get();
        } else {
            throw new IllegalArgumentException
                    ("Não foi encontrada conta bancária com o CPF: " + cpf);
        }
    }
}
