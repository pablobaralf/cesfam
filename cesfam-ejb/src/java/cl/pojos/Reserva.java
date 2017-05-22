/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByCodReserva", query = "SELECT r FROM Reserva r WHERE r.codReserva = :codReserva"),
    @NamedQuery(name = "Reserva.findByFechaEmision", query = "SELECT r FROM Reserva r WHERE r.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Reserva.findByCantidad", query = "SELECT r FROM Reserva r WHERE r.cantidad = :cantidad")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RESERVA")
    private Integer codReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private short cantidad;
    @JoinColumn(name = "LOTE_MED_COD_LOTE", referencedColumnName = "COD_LOTE_MED")
    @ManyToOne(optional = false)
    private LoteMedicamento loteMedCodLote;
    @JoinColumn(name = "MEDICAMENTO_COD_MEDICAMENTO", referencedColumnName = "COD_MEDICAMENTO")
    @ManyToOne(optional = false)
    private Medicamento medicamentoCodMedicamento;

    public Reserva() {
    }

    public Reserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public Reserva(Integer codReserva, Date fechaEmision, short cantidad) {
        this.codReserva = codReserva;
        this.fechaEmision = fechaEmision;
        this.cantidad = cantidad;
    }

    public Integer getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public LoteMedicamento getLoteMedCodLote() {
        return loteMedCodLote;
    }

    public void setLoteMedCodLote(LoteMedicamento loteMedCodLote) {
        this.loteMedCodLote = loteMedCodLote;
    }

    public Medicamento getMedicamentoCodMedicamento() {
        return medicamentoCodMedicamento;
    }

    public void setMedicamentoCodMedicamento(Medicamento medicamentoCodMedicamento) {
        this.medicamentoCodMedicamento = medicamentoCodMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReserva != null ? codReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codReserva == null && other.codReserva != null) || (this.codReserva != null && !this.codReserva.equals(other.codReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Reserva[ codReserva=" + codReserva + " ]";
    }
    
}
