/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Entrega;
import cl.pojos.Formulario;
import cl.pojos.Prescripcion;
import cl.service.EntregaFacadeLocal;
import cl.service.FormularioFacadeLocal;
import cl.service.PrescripcionFacadeLocal;
import java.util.Date;
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
@Named(value = "entregaBean")
@RequestScoped
public class entregaBean {

    @EJB
    private PrescripcionFacadeLocal prescripcionFacade;

    @EJB
    private FormularioFacadeLocal formularioFacade;

    @EJB
    private EntregaFacadeLocal entregaFacade;

    private int codEntrega;
    private Date fechaEmision;
    //
    private Entrega entrega;
    private Prescripcion prescripcion;
    private Formulario formulario;

    public entregaBean() {
        entrega = new Entrega();
        prescripcion = new Prescripcion();
        formulario = new Formulario();
    }

    public List<Entrega> getEntregas() {
        return entregaFacade.findAll();
    }

    public int getCodEntrega() {
        return codEntrega;
    }

    public void setCodEntrega(int codEntrega) {
        this.codEntrega = codEntrega;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Prescripcion getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(Prescripcion prescripcion) {
        this.prescripcion = prescripcion;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public String create() {
        Entrega e = new Entrega();
        
        e.setFormularioCodFormulario(formularioFacade.find(formulario.getCodFormulario()));
        e.setPrescripcionCodPrescripcion(prescripcionFacade.find(prescripcion.getCodPrescripcion()));
        Prescripcion p = prescripcionFacade.find(prescripcion.getCodPrescripcion());
        e.setCodEntrega(entrega.getCodEntrega());
        e.setFechaEmision(new Date());
        p.setEstado("Entregada");
        prescripcionFacade.edit(p);
      
        entregaFacade.create(e);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Prescripción Entregada!", ""));

        return "index";
    }

}
