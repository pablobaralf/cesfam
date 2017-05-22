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
@Table(name = "CADUCIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caducidad.findAll", query = "SELECT c FROM Caducidad c"),
    @NamedQuery(name = "Caducidad.findByCodCaducidad", query = "SELECT c FROM Caducidad c WHERE c.codCaducidad = :codCaducidad"),
    @NamedQuery(name = "Caducidad.findByFechaEmision", query = "SELECT c FROM Caducidad c WHERE c.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Caducidad.findByMotivo", query = "SELECT c FROM Caducidad c WHERE c.motivo = :motivo"),
    @NamedQuery(name = "Caducidad.findByCantidad", query = "SELECT c FROM Caducidad c WHERE c.cantidad = :cantidad")})
public class Caducidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CADUCIDAD")
    private Integer codCaducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MOTIVO")
    private String motivo;
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

    public Caducidad() {
    }

    public Caducidad(Integer codCaducidad) {
        this.codCaducidad = codCaducidad;
    }

    public Caducidad(Integer codCaducidad, Date fechaEmision, String motivo, short cantidad) {
        this.codCaducidad = codCaducidad;
        this.fechaEmision = fechaEmision;
        this.motivo = motivo;
        this.cantidad = cantidad;
    }

    public Integer getCodCaducidad() {
        return codCaducidad;
    }

    public void setCodCaducidad(Integer codCaducidad) {
        this.codCaducidad = codCaducidad;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        hash += (codCaducidad != null ? codCaducidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caducidad)) {
            return false;
        }
        Caducidad other = (Caducidad) object;
        if ((this.codCaducidad == null && other.codCaducidad != null) || (this.codCaducidad != null && !this.codCaducidad.equals(other.codCaducidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Caducidad[ codCaducidad=" + codCaducidad + " ]";
    }
    
}
