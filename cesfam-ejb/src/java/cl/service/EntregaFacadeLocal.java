/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Entrega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface EntregaFacadeLocal {

    void create(Entrega entrega);

    void edit(Entrega entrega);

    void remove(Entrega entrega);

    Entrega find(Object id);

    List<Entrega> findAll();

    List<Entrega> findRange(int[] range);

    int count();

}
