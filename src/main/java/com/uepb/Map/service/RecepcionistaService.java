package com.uepb.Map.service;

import com.uepb.Map.model.Recepcionista;
import com.uepb.Map.repository.RecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class RecepcionistaService {

    @Autowired
    RecepcionistaRepository recepcionistaRepository;

    //Find methods
    public List<Recepcionista> findAll() {
        return recepcionistaRepository.findAll();
    }

    public Optional<Recepcionista> findById(Integer id) {
        return recepcionistaRepository.findById(id);
    }

    //Save methods
    public void save(Recepcionista recepcionista) {
        recepcionistaRepository.save(recepcionista);
    }

    public void saveAndFlush(Recepcionista recepcionista) {
        recepcionistaRepository.saveAndFlush(recepcionista);
    }

    public void saveAll(List<Recepcionista> recepcionistaList) {
        recepcionistaRepository.saveAll(recepcionistaList);
    }

    public void saveAllAndFlush(List<Recepcionista> recepcionistaList) {
        recepcionistaRepository.saveAllAndFlush(recepcionistaList);
    }

    public boolean deleteById(Integer id) {
        if (recepcionistaRepository.existsById(id)) {
            recepcionistaRepository.deleteById(id);
            return !recepcionistaRepository.existsById(id);
        }
        return false;
    }
}
