/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.CarnetFam;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface CarnetFamFacadeLocal {

    void create(CarnetFam carnetFam);

    void edit(CarnetFam carnetFam);

    void remove(CarnetFam carnetFam);

    CarnetFam find(Object id);

    List<CarnetFam> findAll();

    List<CarnetFam> findRange(int[] range);

    int count();

}
