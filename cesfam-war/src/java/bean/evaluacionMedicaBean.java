/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.EvaluacionMed;
import cl.pojos.Formulario;
import cl.service.EvaluacionMedFacadeLocal;
import cl.service.FormularioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Dany
 */
@Named(value = "evaluacionMedicaBean")
@SessionScoped
public class evaluacionMedicaBean implements Serializable {

    @EJB
    private FormularioFacadeLocal formularioFacade;

    @EJB
    private EvaluacionMedFacadeLocal evaluacionMedFacade;
    
    private int codEvaluacion;
    private String indicacionesMedicas;
    //
    private EvaluacionMed evaluacionMedica;
    private Formulario formulario;
    
    
    public evaluacionMedicaBean() {
        evaluacionMedica = new EvaluacionMed();
        formulario = new Formulario();
        
    }
    
    public List<EvaluacionMed> getEvaluacionesMedicas(){
        return evaluacionMedFacade.findAll();
    }

    public int getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(int codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public String getIndicacionesMedicas() {
        return indicacionesMedicas;
    }

    public void setIndicacionesMedicas(String indicacionesMedicas) {
        this.indicacionesMedicas = indicacionesMedicas;
    }

    public EvaluacionMed getEvaluacionMedica() {
        return evaluacionMedica;
    }

    public void setEvaluacionMedica(EvaluacionMed evaluacionMedica) {
        this.evaluacionMedica = evaluacionMedica;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
    
    public String create(){
        EvaluacionMed e = new EvaluacionMed();
        e.setFormularioCodFormulario(formularioFacade.find(evaluacionMedica.getCodEvaluacion()));
        e.setCodEvaluacion(evaluacionMedica.getCodEvaluacion());
        e.setFechaEmision(new Date());
        e.setIndicacionesMedicas(evaluacionMedica.getIndicacionesMedicas());
        evaluacionMedFacade.create(e);
        
        return "index";
        
        
    }
    
    
}
