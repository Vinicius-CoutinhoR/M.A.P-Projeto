package com.uepb.Map.service;

import com.uepb.Map.model.Consulta;
import com.uepb.Map.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    //Find methods
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Integer id) {
        return consultaRepository.findById(id);
    }

    //Save methods
    public void save(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void saveAndFlush(Consulta consulta) {
        consultaRepository.saveAndFlush(consulta);
    }

    public void saveAll(List<Consulta> consultaList) {
        consultaRepository.saveAll(consultaList);
    }

    public void saveAllAndFlush(List<Consulta> consultaList) {
        consultaRepository.saveAllAndFlush(consultaList);
    }
}
