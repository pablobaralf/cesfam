/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Tutor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface TutorFacadeLocal {

    void create(Tutor tutor);

    void edit(Tutor tutor);

    void remove(Tutor tutor);

    Tutor find(Object id);

    List<Tutor> findAll();

    List<Tutor> findRange(int[] range);

    int count();

}
