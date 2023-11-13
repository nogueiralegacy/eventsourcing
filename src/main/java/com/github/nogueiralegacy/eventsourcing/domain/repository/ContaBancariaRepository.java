package com.github.nogueiralegacy.eventsourcing.domain.repository;

import com.github.nogueiralegacy.eventsourcing.domain.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface ContaBancariaRepository extends CrudRepository<Transacao, Long> {
}
