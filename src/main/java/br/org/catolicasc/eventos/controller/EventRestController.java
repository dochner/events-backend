package br.org.catolicasc.eventos.controller;

import br.org.catolicasc.eventos.model.Event;
import br.org.catolicasc.eventos.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1")
public class EventRestController {

    @Autowired
    private EventService es;


    @GetMapping(value = "/events")
    public List<Event> getAll(){
        return es.getAll();
    }

    @GetMapping(value = "/events/{id}")
    public Event find(@PathVariable("id") Long id){
        return es.get((id));
    }

    @PostMapping(value = "/events")
    public ResponseEntity<Event> save(@RequestBody Event event){
        Event obj = es.save(event);
        return new ResponseEntity<Event>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/events/{id}")
    public ResponseEntity<Event> delete(@PathVariable("id") Long id){
        Event event = es.get(id);
        if (event != null) {
            es.delete(id);
        } else {
            return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @PutMapping(value = "/events/{id}")
    public ResponseEntity<Event> update(@PathVariable("id") Long id, @RequestBody Event event){
        Event _event = es.get(id);
        if (_event != null ) {
            _event.setDestino(event.getDestino());
            _event.setPessoa(event.getPessoa());
            _event.setEntrance(event.getEntrance());
            _event.setLeave(event.getLeave());
            _event.setVeiculo(event.getVeiculo());
        } else {
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        Event obj =  es.save(_event);
        return new ResponseEntity<Event>(obj, HttpStatus.OK);
    }

}
