/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Prescripcion;
import cl.pojos.Medico;
import cl.service.FormularioFacadeLocal;
import cl.service.MedicoFacadeLocal;
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
@Named(value = "prescripcionBean")
@RequestScoped
public class prescripcionBean {

    @EJB
    private PrescripcionFacadeLocal prescripcionFacade;

    @EJB
    private MedicoFacadeLocal medicoFacade;

    @EJB
    private FormularioFacadeLocal formularioFacade;

    private String codPrescripcion;
    private double cantidadDiaria;
    private int duracionTratamiento;
    //
    private Prescripcion prescripcion;
    private Medico medico;

    public prescripcionBean() {
        prescripcion = new Prescripcion();
        medico = new Medico();
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripcionFacade.findAll();
    }

    public String getCodPrescripcion() {
        return codPrescripcion;
    }

    public void setCodPrescripcion(String codPrescripcion) {
        this.codPrescripcion = codPrescripcion;
    }

    public double getCantidadDiaria() {
        return cantidadDiaria;
    }

    public void setCantidadDiaria(double cantidadDiaria) {
        this.cantidadDiaria = cantidadDiaria;
    }

    public int getDuracionTratamiento() {
        return duracionTratamiento;
    }

    public void setDuracionTratamiento(int duracionTratamiento) {
        this.duracionTratamiento = duracionTratamiento;
    }

    public Prescripcion getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(Prescripcion prescripcion) {
        this.prescripcion = prescripcion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String create() {
        try {
            Prescripcion p = new Prescripcion();
        p.setMedicoCodMedico(medicoBean.verificarSesion());
        p.setCodPrescripcion(prescripcion.getCodPrescripcion());
        p.setFechaEmision(new Date());
        p.setCantidadDiaria(prescripcion.getCantidadDiaria());
        p.setDuracionTratamiento(prescripcion.getDuracionTratamiento());
        p.setEstado("No Entregada");

        prescripcionFacade.create(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prescripción Ingresada"));

        } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prescripción ya existe"));

        }
        
        return "index";
    }

}
