/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Prescripcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface PrescripcionFacadeLocal {

    void create(Prescripcion prescripcion);

    void edit(Prescripcion prescripcion);

    void remove(Prescripcion prescripcion);

    Prescripcion find(Object id);

    List<Prescripcion> findAll();

    List<Prescripcion> findRange(int[] range);

    int count();

}
