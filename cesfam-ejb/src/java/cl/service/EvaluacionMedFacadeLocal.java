/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.EvaluacionMed;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface EvaluacionMedFacadeLocal {

    void create(EvaluacionMed evaluacionMed);

    void edit(EvaluacionMed evaluacionMed);

    void remove(EvaluacionMed evaluacionMed);

    EvaluacionMed find(Object id);

    List<EvaluacionMed> findAll();

    List<EvaluacionMed> findRange(int[] range);

    int count();

}
