package com.josias.crudswing.model;

import java.util.Objects;

public class Funcionario {

    private String cod, nome;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String cod, String nome, double salario) {
        this.cod = cod;
        this.nome = nome;
        this.salario = salario;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return cod + "\n"
                + nome + "\n"
                + salario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cod);
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
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.cod, other.cod);
    }

}
