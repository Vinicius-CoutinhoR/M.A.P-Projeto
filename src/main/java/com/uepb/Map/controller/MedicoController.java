package com.uepb.Map.controller;

import com.uepb.Map.model.Medico;
import com.uepb.Map.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/theranos/medico", produces = "application/json;charset=UTF-8")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @GetMapping
    public ResponseEntity<Object> getAllMedicos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(medicoService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getMedicoById(@PathVariable Integer id) {
        Optional<Medico> medico = medicoService.findById(id);
        if (medico.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(medico);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping
    public ResponseEntity<Object> createMedico(
            @RequestBody Medico medico) {
        if (medico != null) {
            medicoService.saveAndFlush(medico);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping(path = "list")
    public ResponseEntity<Object> createMedicos(
            @RequestBody List<Medico> medicoList) {
        if (medicoList != null) {
            medicoService.saveAll(medicoList);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteMedicoById(@PathVariable Integer id) {
        boolean deleted = medicoService.deleteById(id);
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