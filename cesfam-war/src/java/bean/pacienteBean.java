/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Carnet;
import cl.pojos.CarnetFam;
import cl.pojos.Formulario;
import cl.pojos.Paciente;
import cl.pojos.Tutor;
import cl.service.CarnetFacadeLocal;
import cl.service.CarnetFamFacadeLocal;
import cl.service.FormularioFacadeLocal;
import cl.service.PacienteFacadeLocal;
import cl.service.TutorFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "pacienteBean")
@SessionScoped
public class pacienteBean implements Serializable {

    @EJB
    private FormularioFacadeLocal formularioFacade;

    @EJB
    private CarnetFacadeLocal carnetFacade;

    @EJB
    private CarnetFamFacadeLocal carnetFamFacade;

    @EJB
    private TutorFacadeLocal tutorFacade;

    @EJB
    private PacienteFacadeLocal pacienteFacade;

    private String rutPaciente;
    private String nombre;
    private Date fechaNacimiento;
    private String direccion;
    private int telefono;
    private String email;
    //
    private Paciente paciente;
    private Tutor tutor;
    private CarnetFam carnetFam;

    public pacienteBean() {
        paciente = new Paciente();
        tutor = new Tutor();
        carnetFam = new CarnetFam();
    }

    public List<Paciente> getPacientes() {
        return pacienteFacade.findAll();
    }

    public String getRutPaciente() {
        return rutPaciente;
    }

    public void setRutPaciente(String rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public CarnetFam getCarnetFam() {
        return carnetFam;
    }

    public void setCarnetFam(CarnetFam carnetFam) {
        this.carnetFam = carnetFam;
    }

    public String create() {
        Paciente p = new Paciente();
        Carnet c = new Carnet();
        Formulario f = new Formulario();
        p.setTutorRutTutor(tutorFacade.find(tutor.getRutTutor()));
        p.setCarnetFamCodFam(carnetFamFacade.find(carnetFam.getCodCarnetFam()));
        p.setRutPaciente(paciente.getRutPaciente());
        p.setNombre(paciente.getNombre());
        p.setApellido(paciente.getApellido());
        p.setFechaNacimiento(paciente.getFechaNacimiento());
        p.setDireccion(paciente.getDireccion());
        p.setTelefono(paciente.getTelefono());
        p.setEmail(paciente.getEmail());
        c.setPacienteRutPaciente(p);
        c.setCodCarnet(p.getNombre().toUpperCase().charAt(0) + "" + p.getApellido().toUpperCase().charAt(0) + "" + p.getRutPaciente());
        f.setCarnetCodCarnet(c);
        f.setCodFormulario("FOR" + c.getCodCarnet());
        pacienteFacade.create(p);
        carnetFacade.create(c);
        formularioFacade.create(f);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente Registrado"));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código de Carnet: "+c.getCodCarnet()));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código de Formulario: "+f.getCodFormulario()));

        return "index";
    }

}
