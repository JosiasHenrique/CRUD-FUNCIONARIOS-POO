package com.josias.crudswing.controller;

import com.josias.crudswing.model.Funcionario;
import com.josias.crudswing.model.FuncionarioDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FuncionarioController {

    public void criarFuncionario(String cod, String nome, double salario) throws IOException {
        new FuncionarioDAO().create(new Funcionario(cod, nome, salario));
    }
    
    public Funcionario buscarFuncionario(String cod) throws FileNotFoundException {
        return new FuncionarioDAO().buscarFuncionario(cod);
    }

    public void carregarFuncionarios(JTable jTabela) throws FileNotFoundException {

        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

        FuncionarioDAO func = new FuncionarioDAO();

        Collection<Funcionario> funcionarios = func.listarFuncionarios();

        dtm.setRowCount(funcionarios.size());
        jTabela.setModel(dtm);

        int posicaoLinha = 0;

        for (Funcionario f : funcionarios) {

            jTabela.setValueAt(f.getCod(), posicaoLinha, 0);
            jTabela.setValueAt(f.getNome(), posicaoLinha, 1);
            jTabela.setValueAt(f.getSalario(), posicaoLinha, 2);
            posicaoLinha += 1;
        }
    }
}
