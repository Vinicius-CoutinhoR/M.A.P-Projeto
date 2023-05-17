package com.uepb.Map.service;

import com.uepb.Map.model.Agenda;
import com.uepb.Map.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    //Find methods
    public List<Agenda> findAll() { return agendaRepository.findAll(); }

    public Optional<Agenda> findById(Integer id) { return agendaRepository.findById(id); }

    //Save methods
    public void save(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    public void saveAndFlush(Agenda agenda) { agendaRepository.saveAndFlush(agenda); }

    public void saveAll(List<Agenda> agendaList) { agendaRepository.saveAll(agendaList); }

    public void saveAllAndFlush(List<Agenda> agendaList) { agendaRepository.saveAllAndFlush(agendaList); }
}
