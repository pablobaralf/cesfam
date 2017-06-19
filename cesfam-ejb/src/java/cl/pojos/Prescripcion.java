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
@Table(name = "PRESCRIPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescripcion.findAll", query = "SELECT p FROM Prescripcion p"),
    @NamedQuery(name = "Prescripcion.findByCodPrescripcion", query = "SELECT p FROM Prescripcion p WHERE p.codPrescripcion = :codPrescripcion"),
    @NamedQuery(name = "Prescripcion.findByFechaEmision", query = "SELECT p FROM Prescripcion p WHERE p.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Prescripcion.findByCantidadDiaria", query = "SELECT p FROM Prescripcion p WHERE p.cantidadDiaria = :cantidadDiaria"),
    @NamedQuery(name = "Prescripcion.findByDuracionTratamiento", query = "SELECT p FROM Prescripcion p WHERE p.duracionTratamiento = :duracionTratamiento"),
    @NamedQuery(name = "Prescripcion.findByEstado", query = "SELECT p FROM Prescripcion p WHERE p.estado = :estado")})
public class Prescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_PRESCRIPCION")
    private String codPrescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_DIARIA")
    private double cantidadDiaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION_TRATAMIENTO")
    private short duracionTratamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "MEDICO_COD_MEDICO", referencedColumnName = "COD_MEDICO")
    @ManyToOne(optional = false)
    private Medico medicoCodMedico;

    public Prescripcion() {
    }

    public Prescripcion(String codPrescripcion) {
        this.codPrescripcion = codPrescripcion;
    }

    public Prescripcion(String codPrescripcion, Date fechaEmision, double cantidadDiaria, short duracionTratamiento, String estado) {
        this.codPrescripcion = codPrescripcion;
        this.fechaEmision = fechaEmision;
        this.cantidadDiaria = cantidadDiaria;
        this.duracionTratamiento = duracionTratamiento;
        this.estado = estado;
    }

    public String getCodPrescripcion() {
        return codPrescripcion;
    }

    public void setCodPrescripcion(String codPrescripcion) {
        this.codPrescripcion = codPrescripcion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getCantidadDiaria() {
        return cantidadDiaria;
    }

    public void setCantidadDiaria(double cantidadDiaria) {
        this.cantidadDiaria = cantidadDiaria;
    }

    public short getDuracionTratamiento() {
        return duracionTratamiento;
    }

    public void setDuracionTratamiento(short duracionTratamiento) {
        this.duracionTratamiento = duracionTratamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medico getMedicoCodMedico() {
        return medicoCodMedico;
    }

    public void setMedicoCodMedico(Medico medicoCodMedico) {
        this.medicoCodMedico = medicoCodMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrescripcion != null ? codPrescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescripcion)) {
            return false;
        }
        Prescripcion other = (Prescripcion) object;
        if ((this.codPrescripcion == null && other.codPrescripcion != null) || (this.codPrescripcion != null && !this.codPrescripcion.equals(other.codPrescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Prescripcion[ codPrescripcion=" + codPrescripcion + " ]";
    }
    
}
