package com.uepb.Map.controller;

import com.uepb.Map.model.Consulta;
import com.uepb.Map.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/theranos/consulta", produces = "application/json;charset=UTF-8")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<Object> getAllConsultas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(consultaService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getConsultaById(@PathVariable Integer id) {
        Optional<Consulta> consulta = consultaService.findById(id);
        if (consulta.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(consulta);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping
    public ResponseEntity<Object> createConsulta(
            @RequestBody Consulta consulta) {
        if (consulta != null) {
            consultaService.saveAndFlush(consulta);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping(path = "list")
    public ResponseEntity<Object> createConsultas(
            @RequestBody List<Consulta> consultaList) {
        if (consultaList != null) {
            consultaService.saveAll(consultaList);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAgendaById(@PathVariable Integer id) {
        boolean deleted = consultaService.deleteById(id);
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