package com.uepb.Map.service;

import com.uepb.Map.model.Consulta;
import com.uepb.Map.model.Medico;
import com.uepb.Map.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    //Find methods
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Integer id) {
        return medicoRepository.findById(id);
    }

    //Save methods
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    public void saveAndFlush(Medico medico) {
        medicoRepository.saveAndFlush(medico);
    }

    public void saveAll(List<Medico> medicoList) {
        medicoRepository.saveAll(medicoList);
    }

    public void saveAllAndFlush(List<Medico> medicoList) {
        medicoRepository.saveAllAndFlush(medicoList);
    }

    public boolean deleteById(Integer id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return !medicoRepository.existsById(id);
        }
        return false;
    }

}
