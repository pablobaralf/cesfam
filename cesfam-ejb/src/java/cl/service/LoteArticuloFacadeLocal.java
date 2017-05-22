/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.LoteArticulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface LoteArticuloFacadeLocal {

    void create(LoteArticulo loteArticulo);

    void edit(LoteArticulo loteArticulo);

    void remove(LoteArticulo loteArticulo);

    LoteArticulo find(Object id);

    List<LoteArticulo> findAll();

    List<LoteArticulo> findRange(int[] range);

    int count();
    
    List<Object[]> stockArticulos();
    
}
