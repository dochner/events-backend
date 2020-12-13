package br.org.catolicasc.eventos.service;

import br.org.catolicasc.eventos.model.Event;
import br.org.catolicasc.eventos.repository.EventRepository;
import br.org.catolicasc.eventos.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends GenericServiceImpl<Event, Long> implements EventService {

    @Autowired
    private EventRepository er;

    @Override
    public CrudRepository<Event, Long> getDao() {
        return er;
    }
}
