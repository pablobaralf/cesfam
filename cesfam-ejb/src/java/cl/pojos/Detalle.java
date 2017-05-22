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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
    @NamedQuery(name = "Detalle.findByCodDetalle", query = "SELECT d FROM Detalle d WHERE d.codDetalle = :codDetalle"),
    @NamedQuery(name = "Detalle.findByFechaEmision", query = "SELECT d FROM Detalle d WHERE d.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_DETALLE")
    private String codDetalle;
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
    @JoinColumn(name = "PRESCRIPCION_COD_PRESCRIPCION", referencedColumnName = "COD_PRESCRIPCION")
    @ManyToOne(optional = false)
    private Prescripcion prescripcionCodPrescripcion;

    public Detalle() {
    }

    public Detalle(String codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Detalle(String codDetalle, Date fechaEmision, short cantidad) {
        this.codDetalle = codDetalle;
        this.fechaEmision = fechaEmision;
        this.cantidad = cantidad;
    }

    public String getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(String codDetalle) {
        this.codDetalle = codDetalle;
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

    public Prescripcion getPrescripcionCodPrescripcion() {
        return prescripcionCodPrescripcion;
    }

    public void setPrescripcionCodPrescripcion(Prescripcion prescripcionCodPrescripcion) {
        this.prescripcionCodPrescripcion = prescripcionCodPrescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetalle != null ? codDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.codDetalle == null && other.codDetalle != null) || (this.codDetalle != null && !this.codDetalle.equals(other.codDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Detalle[ codDetalle=" + codDetalle + " ]";
    }
    
}
