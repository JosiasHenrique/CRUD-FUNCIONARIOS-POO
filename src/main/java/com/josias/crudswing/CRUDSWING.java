package com.josias.crudswing;

import com.josias.crudswing.model.FuncionarioDAO;
import com.josias.crudswing.model.Funcionario;
import java.io.FileNotFoundException;
import java.util.Collection;

public class CRUDSWING {

    public static void main(String[] args) throws FileNotFoundException {

        
        FuncionarioDAO dao = FuncionarioDAO.getInstance();
        
        dao.create(new Funcionario("21", "Rogério", 10000));
        dao.create(new Funcionario("23", "Adriana", 15000));
        
        Collection<Funcionario> funcionarios = dao.listarFuncionarios();
        
        for(Funcionario f: funcionarios) {
            System.out.println(f.getNome());
        }
        
        dao.sair(funcionarios);
    }
}
