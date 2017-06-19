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
    public void insertarUsuario(Usuario usuario){
   
        try {
            Query query = em.createNativeQuery("INSERT INTO Usuario (RUT, NOMBRE, APELLIDO, FECHA_NACIMIENTO, DIRECCION, TELEFONO, CLAVE)\n" +
"                     values(?rutUs, ?nombreUs, ?apellidoUs, ?fechaNacimientoUs, ?direccionUs, ?telefonoUs, ora_hash(?claveUs))");
            query.setParameter("rutUs", usuario.getRut());
            query.setParameter("nombreUs", usuario.getNombre());
            query.setParameter("apellidoUs", usuario.getApellido());
            query.setParameter("fechaNacimientoUs", usuario.getFechaNacimiento());
            query.setParameter("direccionUs", usuario.getDireccion());
            query.setParameter("telefonoUs", usuario.getTelefono());
            query.setParameter("claveUs", usuario.getClave());

            query.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
    }

}
