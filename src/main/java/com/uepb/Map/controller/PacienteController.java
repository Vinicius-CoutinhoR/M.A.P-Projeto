package com.uepb.Map.controller;

import com.uepb.Map.model.Paciente;
import com.uepb.Map.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/theranos/paciente", produces = "application/json;charset=UTF-8")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Object> getAllPacientes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pacienteService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getPacienteById(@PathVariable Integer id) {
        Optional<Paciente> paciente = pacienteService.findById(id);
        if (paciente.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paciente);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping
    public ResponseEntity<Object> createPaciente(
            @RequestBody Paciente paciente) {
        if (paciente != null) {
            pacienteService.saveAndFlush(paciente);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping(path = "list")
    public ResponseEntity<Object> createPacientes(
            @RequestBody List<Paciente> pacienteList) {
        if (pacienteList != null) {
            pacienteService.saveAll(pacienteList);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deletePacienteById(@PathVariable Integer id) {
        boolean deleted = pacienteService.deleteById(id);
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