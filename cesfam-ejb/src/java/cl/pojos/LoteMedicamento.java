/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "LOTE_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoteMedicamento.findAll", query = "SELECT l FROM LoteMedicamento l"),
    @NamedQuery(name = "LoteMedicamento.findByCodLoteMed", query = "SELECT l FROM LoteMedicamento l WHERE l.codLoteMed = :codLoteMed"),
    @NamedQuery(name = "LoteMedicamento.findByFechaIngreso", query = "SELECT l FROM LoteMedicamento l WHERE l.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "LoteMedicamento.findByFechaVencimiento", query = "SELECT l FROM LoteMedicamento l WHERE l.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "LoteMedicamento.findByCantidad", query = "SELECT l FROM LoteMedicamento l WHERE l.cantidad = :cantidad"),
    @NamedQuery(name = "LoteMedicamento.findByCantidadInicial", query = "SELECT l FROM LoteMedicamento l WHERE l.cantidadInicial = :cantidadInicial")})
public class LoteMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_LOTE_MED")
    private String codLoteMed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private short cantidad;
    @Column(name = "CANTIDAD_INICIAL")
    private Short cantidadInicial;
    @JoinColumn(name = "MEDICAMENTO_COD_MEDICAMENTO", referencedColumnName = "COD_MEDICAMENTO")
    @ManyToOne(optional = false)
    private Medicamento medicamentoCodMedicamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteMedCodLote")
    private List<Caducidad> caducidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteMedCodLote")
    private List<Detalle> detalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteMedCodLote")
    private List<Reserva> reservaList;

    public LoteMedicamento() {
    }

    public LoteMedicamento(String codLoteMed) {
        this.codLoteMed = codLoteMed;
    }

    public LoteMedicamento(String codLoteMed, Date fechaIngreso, Date fechaVencimiento, short cantidad) {
        this.codLoteMed = codLoteMed;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
    }

    public String getCodLoteMed() {
        return codLoteMed;
    }

    public void setCodLoteMed(String codLoteMed) {
        this.codLoteMed = codLoteMed;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Short getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(Short cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Medicamento getMedicamentoCodMedicamento() {
        return medicamentoCodMedicamento;
    }

    public void setMedicamentoCodMedicamento(Medicamento medicamentoCodMedicamento) {
        this.medicamentoCodMedicamento = medicamentoCodMedicamento;
    }

    @XmlTransient
    public List<Caducidad> getCaducidadList() {
        return caducidadList;
    }

    public void setCaducidadList(List<Caducidad> caducidadList) {
        this.caducidadList = caducidadList;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLoteMed != null ? codLoteMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteMedicamento)) {
            return false;
        }
        LoteMedicamento other = (LoteMedicamento) object;
        if ((this.codLoteMed == null && other.codLoteMed != null) || (this.codLoteMed != null && !this.codLoteMed.equals(other.codLoteMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.LoteMedicamento[ codLoteMed=" + codLoteMed + " ]";
    }
    
}
