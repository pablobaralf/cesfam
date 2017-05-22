/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.LoteArticulo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dany
 */
@Stateless
public class LoteArticuloFacade extends AbstractFacade<LoteArticulo> implements LoteArticuloFacadeLocal {

    @PersistenceContext(unitName = "cesfam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoteArticuloFacade() {
        super(LoteArticulo.class);
    }
    
      public List<Object[]> stockArticulos() {
        List<Object[]> resultados = new ArrayList<>();

        Query query = em.createNativeQuery("SELECT cod_articulo, descripcion_articulo, uso,  total_stock_articulos(cod_articulo) FROM Articulo m ORDER BY cod_articulo");
        resultados.addAll(query.getResultList());

        return resultados;
    }
    
}
