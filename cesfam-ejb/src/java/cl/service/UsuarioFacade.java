/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.service;

import cl.pojos.Usuario;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dany
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "cesfam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    //Insertar usuario con cifrado de clave
    public void insertarUsuario(String rut, String nombre, String apellido, Date date, String direccion, int telefono, String clave){

        try {
            Query query = em.createNativeQuery("INSERT INTO Usuario (RUT, NOMBRE, APELLIDO, FECHA_NACIMIENTO, DIRECCION, TELEFONO, CLAVE)"
                    + " values(?rutUs, ?nombreUs, ?apellidoUs, ?fechaNacimientoUs, ?direccionUs, ?telefonoUs, ?claveUs)");
            query.setParameter("rutUs", rut);
            query.setParameter("nombreUs", nombre);
            query.setParameter("apellidoUs", apellido);
            query.setParameter("fechaNacimientoUs", date);
            query.setParameter("direccionUs", direccion);
            query.setParameter("telefonoUs", telefono);
            query.setParameter("claveUs", clave);

            query.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }

}
