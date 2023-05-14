package com.uepb.Map.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recepcionista")
public class Recepcionista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_RECEPCIONISTA")
    private Integer codRecepcionista;
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

    public Integer getCodRecepcionista() {
        return codRecepcionista;
    }

    public void setCodRecepcionista(Integer codRecepcionista) {
        this.codRecepcionista = codRecepcionista;
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
        return "Recepcionista{" +
                "codRecepcionista=" + codRecepcionista +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public static class RecepcionistaBuilder {
        private Integer codRecepcionista;
        private String cpf;
        private String nome;
        private int idade;
        private String email;
        private String telefone;

        public RecepcionistaBuilder() {}

        public RecepcionistaBuilder withCodRecepcionista(Integer codRecepcionista) {
            this.codRecepcionista = codRecepcionista;
            return this;
        }

        public RecepcionistaBuilder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public RecepcionistaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public RecepcionistaBuilder withIdade(int idade) {
            this.idade = idade;
            return this;
        }

        public RecepcionistaBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public RecepcionistaBuilder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Recepcionista build() {
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setCodRecepcionista(this.codRecepcionista);
            recepcionista.setCpf(this.cpf);
            recepcionista.setNome(this.nome);
            recepcionista.setIdade(this.idade);
            recepcionista.setEmail(this.email);
            recepcionista.setTelefone(this.telefone);
            return recepcionista;
        }
    }
}
