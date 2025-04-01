package com.josias.crudswing.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class FuncionarioDAO {

    private static final String ARQUIVO = "funcionarios.txt";
    private static FuncionarioDAO instancia;
    private final Collection<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioDAO() throws FileNotFoundException {
        carregarFuncionarios();
    }

    public static FuncionarioDAO getInstance() throws FileNotFoundException {
        if (instancia == null) {
            instancia = new FuncionarioDAO();
        }
        return instancia;
    }

    private void carregarFuncionarios() throws FileNotFoundException {

        // Usando try-with-resources para garantir que o Scanner será fechado corretamente
        try (Scanner sc = new Scanner(new FileReader(ARQUIVO))) {

            while (sc.hasNext()) {
                String cod = sc.nextLine();
                String nome = sc.nextLine();
                String salario = sc.nextLine();

                Funcionario funcionario = new Funcionario(cod, nome, Double.parseDouble(salario));
                funcionarios.add(funcionario);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
            throw e;
        }
    }

    public void create(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Collection<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionario(String codigo) {

        for (Funcionario f : funcionarios) {
            if (f.getCod().contains(codigo)) {
                return f;
            }
        }
        return null;
    }

    public void sair() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Funcionario f : funcionarios) {
                writer.println(f.getCod());
                writer.println(f.getNome());
                writer.println(f.getSalario());
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

}
