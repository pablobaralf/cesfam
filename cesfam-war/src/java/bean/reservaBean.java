package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cl.pojos.LoteMedicamento;
import cl.pojos.Medicamento;
import cl.pojos.Reserva;
import cl.service.LoteMedicamentoFacadeLocal;
import cl.service.MedicamentoFacadeLocal;
import cl.service.ReservaFacadeLocal;
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
@Named(value = "reservaBean")
@RequestScoped
public class reservaBean {

    @EJB
    private ReservaFacadeLocal reservaFacade;

    @EJB
    private MedicamentoFacadeLocal medicamentoFacade;

    @EJB
    private LoteMedicamentoFacadeLocal loteMedicamentoFacade;

    private Date fechaEmision;
    private int cantidad;
    //
    private Reserva reserva;
    private Medicamento medicamento;
    private LoteMedicamento loteMedicamento;

    public reservaBean() {
        reserva = new Reserva();
        medicamento = new Medicamento();
        loteMedicamento = new LoteMedicamento();
    }

    public List<Reserva> getReservas() {
        return reservaFacade.findAll();
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public void setLote(LoteMedicamento loteMedicamento) {
        this.loteMedicamento = loteMedicamento;
    }

    public String create() {
        Reserva r = new Reserva();
        r.setMedicamentoCodMedicamento(medicamentoFacade.find(medicamento.getCodMedicamento()));
        r.setLoteMedCodLote(loteMedicamentoFacade.find(loteMedicamento.getCodLoteMed()));
        r.setFechaEmision(new Date());
        r.setCantidad(reserva.getCantidad());
        reservaFacade.create(r);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reserva Registrada"));
        return "index";

    }

}
