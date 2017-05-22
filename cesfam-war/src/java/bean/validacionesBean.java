/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Dany
 */
@Named(value = "validacionesBean")
@Dependent
public class validacionesBean {

    /**
     * Creates a new instance of validacionesBean
     */
    public validacionesBean() {
    }

    public void validateTextos(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        if (((String) arg2).length() < 5) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Ingrese al menos 5 carácteres", ""));

        }
    }
    
     public void validateCodigos(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        if (((String) arg2).length() < 1) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Ingrese al menos 5 carácteres", ""));

        }
    }

    public void validateFechaVencimiento(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        Date fechaActual = new Date();
        Date fechaVencimiento = (Date) arg2;

        long fechaInicialMs = fechaActual.getTime();
        long fechaFinalMs = fechaVencimiento.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

        if (dias < 365) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Fecha de vencimiento del lote debe ser mínimo 1 año luego del ingreso", ""));

        }
    }
    
    public void validateFechaNacimiento(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        Date fechaActual = new Date();
        Date fechaNacimiento = (Date) arg2;

        long fechaHoy = fechaActual.getTime();
        long fechaNacimi = fechaNacimiento.getTime();
        long diferencia = fechaHoy - fechaNacimi;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

        if (dias < 6570) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe tener 18 años", ""));

        }
    }

    public void validateUnidadMinYMax(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int cantidad = Integer.parseInt(arg2.toString());
        if (cantidad < 1 || cantidad > 1000) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Unidades del lote deben ser entre 1 y 1000", ""));

        }
    }

    public void validateCantidadCaducar(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int cantidad = Integer.parseInt(arg2.toString());
        if (cantidad < 1 || cantidad > 100) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Porfavor, ingrese un dígito entre 1 y 100 unidades", ""));

        }
    }
    
    public void validateGramaje(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int gramaje = Integer.parseInt(arg2.toString());
        if (gramaje<1||gramaje>2000) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Porfavor, ingrese un dígito entre 1 y 2000 mg", ""));

        }
    }
    
    public void validateContenido(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int gramaje = Integer.parseInt(arg2.toString());
        if (gramaje<1||gramaje>100) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Porfavor, ingrese un contenido entre 1 y 100 dósis", ""));

        }
    }
    
     public void validateCantidadDiaria(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int cantidadDiaria = Integer.parseInt(arg2.toString());
        if (cantidadDiaria<1||cantidadDiaria>4) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Porfavor, ingrese una cantidad diaria entre 1 y 4", ""));

        }
    }
     
      public void validateDuracionTratamiento(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int duracionTratamiento = Integer.parseInt(arg2.toString());
        if (duracionTratamiento<1) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Porfavor, ingrese una cantidad diaria entre 1 y 4", ""));

        }
    }
      
      public void validateNumeroTelefonico(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
          String numero = arg2.toString();
        if (numero.length() < 9) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "El número de contacto debe tener al menos 9 dígitos", ""));

        }
        
    }
      
          public boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
     
   
    
    
    
}
