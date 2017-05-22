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
import javax.persistence.OneToOne;
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
@Table(name = "ENTREGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByCodEntrega", query = "SELECT e FROM Entrega e WHERE e.codEntrega = :codEntrega"),
    @NamedQuery(name = "Entrega.findByFechaEmision", query = "SELECT e FROM Entrega e WHERE e.fechaEmision = :fechaEmision")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ENTREGA")
    private Integer codEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @JoinColumn(name = "FORMULARIO_COD_FORMULARIO", referencedColumnName = "COD_FORMULARIO")
    @ManyToOne(optional = false)
    private Formulario formularioCodFormulario;
    @JoinColumn(name = "PRESCRIPCION_COD_PRESCRIPCION", referencedColumnName = "COD_PRESCRIPCION")
    @OneToOne(optional = false)
    private Prescripcion prescripcionCodPrescripcion;

    public Entrega() {
    }

    public Entrega(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public Entrega(Integer codEntrega, Date fechaEmision) {
        this.codEntrega = codEntrega;
        this.fechaEmision = fechaEmision;
    }

    public Integer getCodEntrega() {
        return codEntrega;
    }

    public void setCodEntrega(Integer codEntrega) {
        this.codEntrega = codEntrega;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Formulario getFormularioCodFormulario() {
        return formularioCodFormulario;
    }

    public void setFormularioCodFormulario(Formulario formularioCodFormulario) {
        this.formularioCodFormulario = formularioCodFormulario;
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
        hash += (codEntrega != null ? codEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.codEntrega == null && other.codEntrega != null) || (this.codEntrega != null && !this.codEntrega.equals(other.codEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Entrega[ codEntrega=" + codEntrega + " ]";
    }
    
}
