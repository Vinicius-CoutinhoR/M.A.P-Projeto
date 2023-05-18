package com.uepb.Map.controller;

import com.uepb.Map.model.Agenda;
import com.uepb.Map.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/theranos/agenda", produces = "application/json;charset=UTF-8")
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @GetMapping
    public ResponseEntity<Object> getAllAgendas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(agendaService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getAgendaById(@PathVariable Integer id) {
        Optional<Agenda> agenda = agendaService.findById(id);
        if (agenda.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(agenda);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping
    public ResponseEntity<Object> createAgenda(
            @RequestBody Agenda agenda) {
        if (agenda != null) {
            agendaService.saveAndFlush(agenda);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping(path = "list")
    public ResponseEntity<Object> createAgendas(
            @RequestBody List<Agenda> agendaList) {
        if (agendaList != null) {
            agendaService.saveAll(agendaList);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAgendaById(@PathVariable Integer id) {
        boolean deleted = agendaService.deleteById(id);
        if (deleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}