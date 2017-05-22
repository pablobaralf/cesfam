/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.LoteMedicamento;
import cl.pojos.Medicamento;
import cl.service.LoteMedicamentoFacadeLocal;
import cl.service.MedicamentoFacadeLocal;
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
@Named(value = "loteMedBean")
@RequestScoped
public class loteMedBean {

    @EJB
    private LoteMedicamentoFacadeLocal loteMedicamentoFacade;

    @EJB
    private MedicamentoFacadeLocal medicamentoFacade;

    private String codLoteMed;
    private Date fechaVencimiento;
    private int cantidad;
    //
    private LoteMedicamento loteMedicamento;
    private Medicamento medicamento;

    public loteMedBean() {
        loteMedicamento = new LoteMedicamento();
        medicamento = new Medicamento();
    }

    public List<LoteMedicamento> getLotesMedicamentos() {
        return loteMedicamentoFacade.findAll();
    }

    public List<Object[]> getStockMedicamentos() {
        return loteMedicamentoFacade.stockMedicamentos();
    }

    public String getCodLoteMed() {
        return codLoteMed;
    }

    public void setCodLoteMed(String codLoteMed) {
        this.codLoteMed = codLoteMed;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LoteMedicamento getLoteMedicamento() {
        return loteMedicamento;
    }

    public void setLoteMedicamento(LoteMedicamento loteMedicamento) {
        this.loteMedicamento = loteMedicamento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String create() {
        try {
            LoteMedicamento l = new LoteMedicamento();
            l.setMedicamentoCodMedicamento(medicamentoFacade.find(medicamento.getCodMedicamento()));
            l.setCodLoteMed(loteMedicamento.getCodLoteMed());
            l.setFechaIngreso(new Date());
            l.setFechaVencimiento(loteMedicamento.getFechaVencimiento());
            l.setCantidad(loteMedicamento.getCantidad());
            l.setCantidadInicial(loteMedicamento.getCantidad());
            loteMedicamentoFacade.create(l);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lote Ingresado"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error"));

        }

        return "index";

    }

//    public void pdfView() {
//        lista = getLotes().toString();
//
//        Document document = new Document(PageSize.A4);
//        System.out.println("document created");
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream("HelloRoco.pdf"));
//            document.addTitle(new Date().toString());
//            System.out.println("write instance created..");
//            document.open();
//            System.out.println();
//            Paragraph p1 = new Paragraph(loteFacade.pruebita());
//            document.add(p1);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        document.close();
//    }
}
