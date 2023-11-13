package com.github.nogueiralegacy.eventsourcing.service;

import com.github.nogueiralegacy.eventsourcing.domain.repository.ContaBancariaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {
    private final ContaBancariaRepository contaBancariaRepository;

    public ContaBancariaService(ContaBancariaRepository contaBancariaRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
    }

}
