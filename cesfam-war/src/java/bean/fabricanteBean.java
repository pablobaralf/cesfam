/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Fabricante;
import cl.service.FabricanteFacadeLocal;
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
@Named(value = "fabricanteBean")
@RequestScoped
public class fabricanteBean {

    @EJB
    private FabricanteFacadeLocal fabricanteFacade;

    private Fabricante fabricante;

    private String descripcionFabricante;

    public fabricanteBean() {
        fabricante = new Fabricante();
    }

    public List<Fabricante> getFabricantes() {
        return fabricanteFacade.findAll();
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescripcionFabricante() {
        return descripcionFabricante;
    }

    public void setDescripcionFabricante(String descripcionFabricante) {
        this.descripcionFabricante = descripcionFabricante;
    }

    public String create() {
        Fabricante f = new Fabricante();
        f.setDescripcionFabricante(fabricante.getDescripcionFabricante());
        fabricanteFacade.create(f);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fabricante Registrado"));
        return "index";
    }

}
