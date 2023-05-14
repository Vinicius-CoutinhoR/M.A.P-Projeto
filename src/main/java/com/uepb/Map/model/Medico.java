package com.uepb.Map.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_MEDICO")
    private Integer codMedico;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "IDADE")
    private int idade;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONE")
    private String telefone;

    private Medico() {};

    public Integer getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Integer codMedico) {
        this.codMedico = codMedico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "codMedico=" + codMedico +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public static class Builder {
        private Integer codMedico;
        private String cpf;
        private String nome;
        private int idade;
        private String email;
        private String telefone;

        public Builder withCodMedico(Integer codMedico) {
            this.codMedico = codMedico;
            return this;
        }

        public Builder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withIdade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Medico build() {
            Medico medico = new Medico();
            medico.setCodMedico(this.codMedico);
            medico.setCpf(this.cpf);
            medico.setNome(this.nome);
            medico.setIdade(this.idade);
            medico.setEmail(this.email);
            medico.setTelefone(this.telefone);
            return medico;
        }
    }
}
