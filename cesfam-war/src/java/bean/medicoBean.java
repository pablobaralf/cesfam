/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Medico;
import cl.pojos.Usuario;
import cl.service.MedicoFacadeLocal;
import cl.service.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "medicoBean")
@SessionScoped
public class medicoBean implements Serializable{

    @EJB
    private MedicoFacadeLocal medicoFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private String codMedico;
    //
    private Medico medico;
    private Usuario usuario;

    public medicoBean() {
        medico = new Medico();
        usuario = new Usuario();
    }

    public List<Medico> getMedicos() {
        return medicoFacade.findAll();
    }

    public String getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(String codMedico) {
        this.codMedico = codMedico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String create() {
        Medico m = new Medico();
        m.setRut(usuarioFacade.find(usuario.getRut()));
        m.setCodMedico(medico.getCodMedico());
        medicoFacade.create(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prescripción Ingresada"));

        return "indexMedico";
    }

    public String iniciarSesionMedico() {
        Medico m;
        try {
            m = medicoFacade.iniciarSesionMedico(medico, usuario);
            if (m != null) {
                //Guardar usuario logeado en la sesión
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("medico", m);
                return "indexMedico";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Incorrecto", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Fallido", ""));

        }

        return null;
    }
    
    
    public static Medico verificarSesion() {
        try {
            //Retornar usuario logeado para operaciones
            Medico med = (Medico) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("medico");

            if (med == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                return null;

            } else {
                return med;
            }

        } catch (Exception e) {
            return null;

        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }


    public String insertarMedico() {
        medicoFacade.insertarMedico(medico,usuario);
        return "index";

    }

}
