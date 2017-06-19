/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Usuario;
import cl.service.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "usuarioBean")
@SessionScoped
public class usuarioBean implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private String rut;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String direccion;
    private short numero;
    private String clave;

    private Usuario usuario;

    public usuarioBean() {
        usuario = new Usuario();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String create() {
        try {
            Usuario u = new Usuario();
            u.setRut(usuario.getRut());
            u.setNombre(usuario.getNombre());
            u.setApellido(usuario.getApellido());
            u.setFechaNacimiento(usuario.getFechaNacimiento());
            u.setDireccion(usuario.getDireccion());
            u.setTelefono(usuario.getTelefono());
            u.setClave(usuario.getClave());
            usuarioFacade.create(u);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario creado"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario ya existe, revise lo ingresado"));

        }

        return "index";
    }

    public String insertarUsuario() {
        try {
            usuarioFacade.insertarUsuario(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Creado"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario ya existe, revise lo ingresado"));
        }   
        return "index";
    }

}
