/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Funcionario;
import cl.pojos.Usuario;
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
public class FuncionarioFacade extends AbstractFacade<Funcionario> implements FuncionarioFacadeLocal {

    @PersistenceContext(unitName = "cesfam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioFacade() {
        super(Funcionario.class);
    }


    
    public Funcionario iniciarSesionFuncionario(Funcionario funcionario, Usuario usuario) {
        Funcionario f = null;
        try {

            Query query = em.createNativeQuery("SELECT * FROM Funcionario f join Usuario u on f.rut=u.rut WHERE f.cod_funcionario=?codFun and u.clave=?claveUs", Funcionario.class);
            query.setParameter("codFun", funcionario.getCodFuncionario());
            query.setParameter("claveUs", usuario.getClave());
            List<Funcionario> lista = query.getResultList();

            if (!lista.isEmpty()) {
                f = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return f;
    }
    
    
    
      public void insertarFuncionario(Funcionario funcionario, Usuario usuario) {
        try {
            Query query = em.createNativeQuery("INSERT INTO Funcionario (cod_funcionario, RUT) values(?codMed, ?rutUs)");
            query.setParameter("codMed", funcionario.getCodFuncionario());
            query.setParameter("rutUs", usuario.getRut());

            query.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }

}
