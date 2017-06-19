/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Medico;
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
public class MedicoFacade extends AbstractFacade<Medico> implements MedicoFacadeLocal {

    @PersistenceContext(unitName = "cesfam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicoFacade() {
        super(Medico.class);
    }

    public Medico iniciarSesionMedico(Medico medico, Usuario usuario) {
        Medico m = null;
        try {

            Query query = em.createNativeQuery("SELECT * FROM Medico m join Usuario u on m.rut=u.rut WHERE m.COD_MEDICO=?codMed and u.clave=ora_hash(?claveUs)", Medico.class);
            query.setParameter("codMed", medico.getCodMedico());
            query.setParameter("claveUs", usuario.getClave());
            List<Medico> lista = query.getResultList();

            if (!lista.isEmpty()) {
                m = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return m;
    }

    public void insertarMedico(Medico medico, Usuario usuario) {
        try {
            Query query = em.createNativeQuery("INSERT INTO Medico (COD_MEDICO, RUT) values(?codMed, ?rutUs)");
            query.setParameter("codMed", medico.getCodMedico());
            query.setParameter("rutUs", usuario.getRut());

            query.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }

}
