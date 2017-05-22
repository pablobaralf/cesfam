package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cl.pojos.Caducidad;
import cl.pojos.LoteMedicamento;
import cl.pojos.Medicamento;
import cl.service.CaducidadFacadeLocal;
import cl.service.LoteMedicamentoFacadeLocal;
import cl.service.MedicamentoFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "caducidadBean")
@RequestScoped
public class caducidadBean {

    @EJB
    private LoteMedicamentoFacadeLocal loteMedicamentoFacade;

    @EJB
    private MedicamentoFacadeLocal medicamentoFacade;

    @EJB
    private CaducidadFacadeLocal caducidadFacade;

    private int codCaducidad;
    private int cantidad;
    private String motivo;
    //
    private Caducidad caducidad;
    private Medicamento medicamento;
    private LoteMedicamento loteMedicamento;

    public caducidadBean() {
        caducidad = new Caducidad();
        medicamento = new Medicamento();
        loteMedicamento = new LoteMedicamento();
    }

    public int getCodCaducidad() {
        return codCaducidad;
    }

    public void setCodCaducidad(int codCaducidad) {
        this.codCaducidad = codCaducidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Caducidad getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Caducidad caducidad) {
        this.caducidad = caducidad;
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

    public String create() {
        try {
            Caducidad c = new Caducidad();

            c.setMedicamentoCodMedicamento(medicamentoFacade.find(medicamento.getCodMedicamento()));
            c.setLoteMedCodLote(loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()));
            c.setCodCaducidad(caducidad.getCodCaducidad());
            c.setFechaEmision(new Date());
            c.setCantidad(caducidad.getCantidad());
            c.setMotivo(caducidad.getMotivo());

            if (medicamentoFacade.find(medicamento.getCodMedicamento()).getCodMedicamento() == loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()).getMedicamentoCodMedicamento().getCodMedicamento()) {

                caducidadFacade.create(c);
                loteMedicamentoFacade.salidaStock(medicamentoFacade.find(medicamento.getCodMedicamento()), loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()), caducidad.getCantidad());

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación realizada exitosamente", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El lote ingresado no corresponde al medicamento", ""));

            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, lote no existe o ya hay una orden de caducidad asociada al código", ""));

        }

        return "index";

    }
}
