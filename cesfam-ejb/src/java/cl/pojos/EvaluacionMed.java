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
@Table(name = "EVALUACION_MED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionMed.findAll", query = "SELECT e FROM EvaluacionMed e"),
    @NamedQuery(name = "EvaluacionMed.findByCodEvaluacion", query = "SELECT e FROM EvaluacionMed e WHERE e.codEvaluacion = :codEvaluacion"),
    @NamedQuery(name = "EvaluacionMed.findByFechaEmision", query = "SELECT e FROM EvaluacionMed e WHERE e.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "EvaluacionMed.findByIndicacionesMedicas", query = "SELECT e FROM EvaluacionMed e WHERE e.indicacionesMedicas = :indicacionesMedicas")})
public class EvaluacionMed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EVALUACION")
    private Integer codEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "INDICACIONES_MEDICAS")
    private String indicacionesMedicas;
    @JoinColumn(name = "FORMULARIO_COD_FORMULARIO", referencedColumnName = "COD_FORMULARIO")
    @ManyToOne(optional = false)
    private Formulario formularioCodFormulario;

    public EvaluacionMed() {
    }

    public EvaluacionMed(Integer codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public EvaluacionMed(Integer codEvaluacion, Date fechaEmision, String indicacionesMedicas) {
        this.codEvaluacion = codEvaluacion;
        this.fechaEmision = fechaEmision;
        this.indicacionesMedicas = indicacionesMedicas;
    }

    public Integer getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(Integer codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getIndicacionesMedicas() {
        return indicacionesMedicas;
    }

    public void setIndicacionesMedicas(String indicacionesMedicas) {
        this.indicacionesMedicas = indicacionesMedicas;
    }

    public Formulario getFormularioCodFormulario() {
        return formularioCodFormulario;
    }

    public void setFormularioCodFormulario(Formulario formularioCodFormulario) {
        this.formularioCodFormulario = formularioCodFormulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEvaluacion != null ? codEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionMed)) {
            return false;
        }
        EvaluacionMed other = (EvaluacionMed) object;
        if ((this.codEvaluacion == null && other.codEvaluacion != null) || (this.codEvaluacion != null && !this.codEvaluacion.equals(other.codEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.EvaluacionMed[ codEvaluacion=" + codEvaluacion + " ]";
    }
    
}
