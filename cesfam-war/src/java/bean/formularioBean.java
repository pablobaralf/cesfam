/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Carnet;
import cl.pojos.Formulario;
import cl.service.CarnetFacadeLocal;
import cl.service.FormularioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "formularioBean")
@RequestScoped
public class formularioBean {

    @EJB
    private FormularioFacadeLocal formularioFacade;

    @EJB
    private CarnetFacadeLocal carnetFacade;

    private String codFormulario;
    //
    private Formulario formulario;
    private Carnet carnet;

    public formularioBean() {
        formulario = new Formulario();
        carnet = new Carnet();
    }

    public List<Formulario> getFormularios() {
        return formularioFacade.findAll();
    }

    public String getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(String codFormulario) {
        this.codFormulario = codFormulario;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }


}
