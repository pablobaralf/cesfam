/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.LoteMedicamento;
import cl.pojos.Medicamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dany
 */
@Local
public interface LoteMedicamentoFacadeLocal {

    void create(LoteMedicamento loteMedicamento);

    void edit(LoteMedicamento loteMedicamento);

    void remove(LoteMedicamento loteMedicamento);

    LoteMedicamento find(Object id);

    List<LoteMedicamento> findAll();

    List<LoteMedicamento> findRange(int[] range);

    int count();
    
    List<Object[]> stockMedicamentos();
    
    void salidaStock(Medicamento medicamento, LoteMedicamento loteMedicamento, int cantidad);
    
    void cancelarSalida(Medicamento medicamento, LoteMedicamento loteMedicamento, int cantidad);
    
}
