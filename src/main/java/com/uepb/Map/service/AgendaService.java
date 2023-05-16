package com.uepb.Map.service;

import com.uepb.Map.model.Agenda;
import com.uepb.Map.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    public void save(Agenda agenda) {
        agendaRepository.saveAndFlush(agenda);
    }

    public void saveAll(Agenda agenda) {
        agendaRepository.saveAndFlush(agenda);
    }


}
