package com.uepb.Map.service;

import com.uepb.Map.model.Paciente;
import com.uepb.Map.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    //Find methods
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    //Save methods
    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public void saveAndFlush(Paciente paciente) {
        pacienteRepository.saveAndFlush(paciente);
    }

    public void saveAll(List<Paciente> pacienteList) {
        pacienteRepository.saveAll(pacienteList);
    }

    public void saveAllAndFlush(List<Paciente> pacienteList) {
        pacienteRepository.saveAllAndFlush(pacienteList);
    }
}
