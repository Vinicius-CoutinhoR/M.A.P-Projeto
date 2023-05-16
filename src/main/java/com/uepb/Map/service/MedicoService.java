package com.uepb.Map.service;

import com.uepb.Map.model.Medico;
import com.uepb.Map.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public void save(Medico medico) {
        medicoRepository.saveAndFlush(medico);
    }


}
