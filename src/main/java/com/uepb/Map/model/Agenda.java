package com.uepb.Map.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_AGENDA")
    private Integer codAgenda;
    @Column(name = "COD_MEDICO")
    private Integer codMedico;


}
