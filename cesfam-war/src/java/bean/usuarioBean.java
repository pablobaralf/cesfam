package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cl.pojos.Medico;
import cl.pojos.Usuario;
import cl.service.UsuarioFacadeLocal;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "usuarioBean")
@RequestScoped
public class usuarioBean {

    private UsuarioFacadeLocal usuarioFacade;

    private Usuario usuario;
    /**
     * Creates a new instance of usuarioBean
     */
    private String rut;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String direccion;
    private int telefono;
    private String clave;

    public usuarioBean() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String create() {
        Usuario u = new Usuario();
        u.setRut(usuario.getRut());
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setFechaNacimiento(usuario.getFechaNacimiento());
        u.setDireccion(usuario.getDireccion());
        u.setTelefono(usuario.getTelefono());

        usuarioFacade.create(u);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario registrado con éxito"));
return "index";
    }

    public String insertarUsuario() {
        usuarioFacade.insertarUsuario(usuario.getRut(), usuario.getNombre(), usuario.getApellido(), new Date(), usuario.getDireccion(), usuario.getTelefono(), usuario.getClave());
        return "index";
    }

}
