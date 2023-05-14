package com.uepb.Map.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_CONSULTA")
    private Integer codConsulta;
    @Column(name = "COD_AGENDA")
    private Integer codAgenda;
    @Column(name = "COD_MEDICO")
    private Integer codMedico;
    @Column(name = "COD_PACIENTE")
    private Integer codPaciente;
    @Column(name = "DATA")
    private Date data;
    @Column(name = "MEDICAMENTOS")
    private String medicamentos;
}
