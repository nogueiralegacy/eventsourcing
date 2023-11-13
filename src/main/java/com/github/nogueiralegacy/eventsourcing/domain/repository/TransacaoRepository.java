package com.github.nogueiralegacy.eventsourcing.domain.repository;

import com.github.nogueiralegacy.eventsourcing.domain.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

}
