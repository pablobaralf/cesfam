/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.CarnetFam;
import cl.service.CarnetFamFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Dany
 */
@Named(value = "carnetFamBean")
@SessionScoped
public class carnetFamBean implements Serializable {

    @EJB
    private CarnetFamFacadeLocal carnetFamFacade;

    private int codCarnetFam;
    private String color;
    //
    private CarnetFam carnetFam;

    public carnetFamBean() {
        carnetFam = new CarnetFam();
    }

    public List<CarnetFam> getCarnetsFam() {
        return carnetFamFacade.findAll();
    }

    public int getCodCarnetFam() {
        return codCarnetFam;
    }

    public void setCodCarnetFam(int codCarnetFam) {
        this.codCarnetFam = codCarnetFam;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarnetFam getCarnetFam() {
        return carnetFam;
    }

    public void setCarnetFam(CarnetFam carnetFam) {
        this.carnetFam = carnetFam;
    }
    
    

}
