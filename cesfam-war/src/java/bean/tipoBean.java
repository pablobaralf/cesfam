/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Tipo;
import cl.service.TipoFacadeLocal;
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
@Named(value = "tipoBean")
@RequestScoped
public class tipoBean {

    @EJB
    private TipoFacadeLocal tipoFacade;

    private Tipo tipo;

    private List<Tipo> listOfMedicamento;

    private String descripcionTipo;

    public tipoBean() {
        tipo = new Tipo();
    }

    public List<Tipo> getTipos() {
        listOfMedicamento = tipoFacade.findAll();
        return listOfMedicamento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public List<Tipo> getListOfMedicamento() {
        return listOfMedicamento;
    }

    public void setListOfMedicamento(List<Tipo> listOfMedicamento) {
        this.listOfMedicamento = listOfMedicamento;
    }

    public String create() {
        Tipo t = new Tipo();
        t.setDescripcionTipo(tipo.getDescripcionTipo());
        tipoFacade.create(t);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de Medicamento Registrado"));
        return "index";
    }

//        JasperPrint jasperPrint;
//
//    public void init() throws JRException {
//
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listOfMedicamento);
//        jasperPrint = JasperFillManager.fillReport("C:\\Users\\Dany\\Desktop\\report.jasper", new HashMap(), beanCollectionDataSource);
//
//    }
//
//    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
//        init();
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
//    }
}
