/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Tutor;
import cl.service.TutorFacadeLocal;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Dany
 */
@Named(value = "tutorBean")
@SessionScoped
@ManagedBean
public class tutorBean implements Serializable {

    @EJB
    private TutorFacadeLocal tutorFacade;

    private String rutTutor;
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    //
    private Tutor tutor;
    
    public tutorBean() {
        tutor = new Tutor();
    }
    
    public List<Tutor> getTutores(){
        return tutorFacade.findAll();
    }

    public String getRutTutor() {
        return rutTutor;
    }

    public void setRutTutor(String rutTutor) {
        this.rutTutor = rutTutor;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    public String create(){
        Tutor t = new Tutor();
        t.setRutTutor(tutor.getRutTutor());
        t.setNombre(tutor.getNombre());
        t.setApellido(tutor.getApellido());
        t.setTelefono(tutor.getTelefono());
        t.setEmail(tutor.getEmail());
        
        tutorFacade.create(t);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tutor para paciente, ingresado en el sistema"));

        return "index";
        
    }
    
}
