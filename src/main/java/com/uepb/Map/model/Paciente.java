package com.uepb.Map.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_PACIENTE")
    private Integer codPaciente;
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

    private Paciente() {}

    public Integer getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Integer codPaciente) {
        this.codPaciente = codPaciente;
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
        return "Paciente{" +
                "codPaciente=" + codPaciente +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public static class Builder {
        private String cpf;
        private String nome;
        private int idade;
        private String email;
        private String telefone;

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

        public Paciente build() {
            Paciente paciente = new Paciente();
            paciente.setCpf(this.cpf);
            paciente.setNome(this.nome);
            paciente.setIdade(this.idade);
            paciente.setEmail(this.email);
            paciente.setTelefone(this.telefone);
            return paciente;
        }
    }
}
