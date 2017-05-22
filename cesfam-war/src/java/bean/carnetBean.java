/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Carnet;
import cl.pojos.Paciente;
import cl.service.CarnetFacadeLocal;
import cl.service.PacienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Dany
 */
@Named(value = "carnetBean")
@SessionScoped
public class carnetBean implements Serializable {

    @EJB
    private CarnetFacadeLocal carnetFacade;

    @EJB
    private PacienteFacadeLocal pacienteFacade;


    private String codCarnet;
    //
    private Carnet carnet;
    private Paciente paciente;

    public carnetBean() {
        carnet = new Carnet();
        paciente = new Paciente();
    }
    
    public List<Carnet> getCarnets(){
        return carnetFacade.findAll();
    }

    public String getCodCarnet() {
        return codCarnet;
    }

    public void setCodCarnet(String codCarnet) {
        this.codCarnet = codCarnet;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


}
