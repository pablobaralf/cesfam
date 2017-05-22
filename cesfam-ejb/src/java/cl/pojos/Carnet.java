/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "CARNET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carnet.findAll", query = "SELECT c FROM Carnet c"),
    @NamedQuery(name = "Carnet.findByCodCarnet", query = "SELECT c FROM Carnet c WHERE c.codCarnet = :codCarnet")})
public class Carnet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_CARNET")
    private String codCarnet;
    @JoinColumn(name = "PACIENTE_RUT_PACIENTE", referencedColumnName = "RUT_PACIENTE")
    @OneToOne(optional = false)
    private Paciente pacienteRutPaciente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "carnetCodCarnet")
    private Formulario formulario;

    public Carnet() {
    }

    public Carnet(String codCarnet) {
        this.codCarnet = codCarnet;
    }

    public String getCodCarnet() {
        return codCarnet;
    }

    public void setCodCarnet(String codCarnet) {
        this.codCarnet = codCarnet;
    }

    public Paciente getPacienteRutPaciente() {
        return pacienteRutPaciente;
    }

    public void setPacienteRutPaciente(Paciente pacienteRutPaciente) {
        this.pacienteRutPaciente = pacienteRutPaciente;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarnet != null ? codCarnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carnet)) {
            return false;
        }
        Carnet other = (Carnet) object;
        if ((this.codCarnet == null && other.codCarnet != null) || (this.codCarnet != null && !this.codCarnet.equals(other.codCarnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Carnet[ codCarnet=" + codCarnet + " ]";
    }
    
}
