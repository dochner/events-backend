package br.org.catolicasc.eventos.service;

import br.org.catolicasc.eventos.model.Event;
import br.org.catolicasc.eventos.utils.GenericServiceApi;
import org.springframework.context.annotation.Bean;

public interface EventService extends GenericServiceApi<Event, Long> {
}
