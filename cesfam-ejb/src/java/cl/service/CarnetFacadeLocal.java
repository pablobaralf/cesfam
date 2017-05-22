/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Carnet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface CarnetFacadeLocal {

    void create(Carnet carnet);

    void edit(Carnet carnet);

    void remove(Carnet carnet);

    Carnet find(Object id);

    List<Carnet> findAll();

    List<Carnet> findRange(int[] range);

    int count();

}
