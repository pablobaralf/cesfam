/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Detalle;
import cl.pojos.LoteMedicamento;
import cl.pojos.Medicamento;
import cl.pojos.Prescripcion;
import cl.service.DetalleFacadeLocal;
import cl.service.LoteMedicamentoFacadeLocal;
import cl.service.MedicamentoFacadeLocal;
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
@Named(value = "detalleBean")
@RequestScoped
public class detalleBean {

    @EJB
    private LoteMedicamentoFacadeLocal loteMedicamentoFacade;

    @EJB
    private PrescripcionFacadeLocal prescripcionFacade;

    @EJB
    private MedicamentoFacadeLocal medicamentoFacade;

    @EJB
    private DetalleFacadeLocal detalleFacade;

    //
    boolean flag;

    private String codDetalle;
    private int cantidad;
    private Detalle detalle;
    private Medicamento medicamento;
    private LoteMedicamento loteMedicamento;
    private Prescripcion prescripcion;

    public detalleBean() {
        detalle = new Detalle();
        medicamento = new Medicamento();
        prescripcion = new Prescripcion();
        loteMedicamento = new LoteMedicamento();

    }

    public List<Detalle> getDetalles() {
        return detalleFacade.findAll();
    }

    public String getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(String codDetalle) {
        this.codDetalle = codDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public LoteMedicamento getLoteMedicamento() {
        return loteMedicamento;
    }

    public void setLoteMedicamento(LoteMedicamento loteMedicamento) {
        this.loteMedicamento = loteMedicamento;
    }

    public Prescripcion getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(Prescripcion prescripcion) {
        this.prescripcion = prescripcion;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String create() {
        Detalle d = new Detalle();
        double sumaMulti;
        double totalCantidad;
        double contenidoMed;
        double cantidadDosis;

        d.setMedicamentoCodMedicamento(medicamentoFacade.find(medicamento.getCodMedicamento()));
        contenidoMed = d.getMedicamentoCodMedicamento().getContenido();
        d.setPrescripcionCodPrescripcion(prescripcionFacade.find(prescripcion.getCodPrescripcion()));
        cantidadDosis = d.getPrescripcionCodPrescripcion().getCantidadDiaria() * d.getPrescripcionCodPrescripcion().getDuracionTratamiento();
        d.setLoteMedCodLote(loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()));
        d.setCodDetalle(detalle.getCodDetalle());
        d.setFechaEmision(new Date());

        sumaMulti = (double) contenidoMed / cantidadDosis;
        if (contenidoMed < cantidadDosis) {
            sumaMulti = (double) cantidadDosis / contenidoMed;

        }
        totalCantidad = Math.round(sumaMulti);
        if (totalCantidad < 1.0) {
            totalCantidad = 1;
        }

        if (prescripcionFacade.find(prescripcion.getCodPrescripcion()).getDuracionTratamiento() < 10) {

            d.setCantidad((short) totalCantidad);

        } else {
            d.setCantidad(detalle.getCantidad());
        }
        if (medicamentoFacade.find(medicamento.getCodMedicamento()).getCodMedicamento() == loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()).getMedicamentoCodMedicamento().getCodMedicamento()) {

            detalleFacade.create(d);
            loteMedicamentoFacade.salidaStock(medicamentoFacade.find(medicamento.getCodMedicamento()), loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()), d.getCantidad());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de medicamento preparado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El lote ingresado no corresponde al medicamento", ""));

        }

        return "index";
    }

    public String eliminar() {
        Detalle d = detalleFacade.find(detalle.getCodDetalle());
        if (d.getPrescripcionCodPrescripcion().getEstado().equals("No Entregada")) {
            loteMedicamentoFacade.cancelarSalida(d.getMedicamentoCodMedicamento(), d.getLoteMedCodLote(), d.getCantidad());

            detalleFacade.remove(d);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Eliminado, Stock restaurado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error, detalle ya fue entregado, no figura en el Stock"));

        }

        return "index";
    }

}
