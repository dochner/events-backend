package br.org.catolicasc.eventos.repository;

import br.org.catolicasc.eventos.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
