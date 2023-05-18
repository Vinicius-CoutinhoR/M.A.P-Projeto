package com.uepb.Map.controller;

import com.uepb.Map.model.Recepcionista;
import com.uepb.Map.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/theranos/recepcionista", produces = "application/json;charset=UTF-8")
public class RecepcionistaController {

    @Autowired
    RecepcionistaService recepcionistaService;

    @GetMapping
    public ResponseEntity<Object> getAllRecepcionistas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recepcionistaService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getRecepcionistaById(@PathVariable Integer id) {
        Optional<Recepcionista> recepcionista = recepcionistaService.findById(id);
        if (recepcionista.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(recepcionista);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping
    public ResponseEntity<Object> createRecepcionista(
            @RequestBody Recepcionista recepcionista) {
        if (recepcionista != null) {
            recepcionistaService.saveAndFlush(recepcionista);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @PostMapping(path = "list")
    public ResponseEntity<Object> createRecepcionista(
            @RequestBody List<Recepcionista> recepcionistaList) {
        if (recepcionistaList != null) {
            recepcionistaService.saveAll(recepcionistaList);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteRecepcionistaById(@PathVariable Integer id) {
        boolean deleted = recepcionistaService.deleteById(id);
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