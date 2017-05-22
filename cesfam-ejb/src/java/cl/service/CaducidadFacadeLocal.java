/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Caducidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface CaducidadFacadeLocal {

    void create(Caducidad caducidad);

    void edit(Caducidad caducidad);

    void remove(Caducidad caducidad);

    Caducidad find(Object id);

    List<Caducidad> findAll();

    List<Caducidad> findRange(int[] range);

    int count();

}
