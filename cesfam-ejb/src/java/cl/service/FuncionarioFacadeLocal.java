/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Funcionario;
import cl.pojos.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface FuncionarioFacadeLocal {

    void create(Funcionario funcionario);

    void edit(Funcionario funcionario);

    void remove(Funcionario funcionario);

    Funcionario find(Object id);

    List<Funcionario> findAll();

    List<Funcionario> findRange(int[] range);

    int count();

    Funcionario iniciarSesionFuncionario(Funcionario funcionario, Usuario usuario);
    
    void insertarFuncionario(Funcionario funcionario, Usuario usuario);

}
