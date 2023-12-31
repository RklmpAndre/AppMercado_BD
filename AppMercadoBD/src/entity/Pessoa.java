package entity;

import entity.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author andre; arthur
 */
public class Pessoa {

    //relaciona o Usuário com a pessoa
    private Usuario user;
    //cpf será final pois uma pessoa tem apenas 1 cpf
    private String cpf;

    private String nome;

    private LocalDate dataNascimento;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa(String cpf, String nome, LocalDate dataNascimento) {
        setCpf(cpf);
        setNome(nome);
        setDataNascimento(dataNascimento);
    }
    
    public Pessoa(){
        
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        Objects.requireNonNull(user);
        this.user = user;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf){
        Objects.requireNonNull(cpf);
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome);
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoString() {
        return dataNascimento.format(formatter);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        Objects.requireNonNull(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de Nascimento: " + getDataNascimentoString()+ "\n" + getUser();
    }
    
}
