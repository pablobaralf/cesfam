/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.LoteMedicamento;
import cl.pojos.Medicamento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Dany
 */
@Stateless
public class LoteMedicamentoFacade extends AbstractFacade<LoteMedicamento> implements LoteMedicamentoFacadeLocal {

    @PersistenceContext(unitName = "cesfam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoteMedicamentoFacade() {
        super(LoteMedicamento.class);
    }
    
     public List<Object[]> stockMedicamentos() {
        List<Object[]> resultados = new ArrayList<>();

        Query query = em.createNativeQuery("SELECT m.cod_medicamento, m.descripcion_medicamento, m.principio_activo, m.componentes, m.contenido, m.gramaje, t.descripcion_tipo,\n" +
"               f.descripcion_fabricante, (total_stock_medicamentos(cod_medicamento)-total_cantidad_caduc(cod_medicamento)), total_stock_medicamentos(cod_medicamento) FROM Medicamento m join tipo t on m.TIPO_COD_TIPO=t.COD_TIPO\n" +
"                join fabricante f on m.FABRICANTE_COD_FABRICANTE=f.COD_FABRICANTE ORDER BY cod_medicamento");
        resultados.addAll(query.getResultList());

        return resultados;
    }

    public void salidaStock(Medicamento medicamento, LoteMedicamento loteMedicamento, int cantidad) {

        StoredProcedureQuery query = em.createStoredProcedureQuery("salida_stock_med")
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        query.setParameter(1, medicamento.getCodMedicamento());
        query.setParameter(2, loteMedicamento.getCodLoteMed());
        query.setParameter(3, cantidad);

        query.execute();

    }

    public void cancelarSalida(Medicamento medicamento, LoteMedicamento loteMedicamento, int cantidad) {

        StoredProcedureQuery query = em.createStoredProcedureQuery("reingreso_stock_med")
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        query.setParameter(1, medicamento.getCodMedicamento());
        query.setParameter(2, loteMedicamento.getCodLoteMed());
        query.setParameter(3, cantidad);

        query.execute();

    }

   
    
}
