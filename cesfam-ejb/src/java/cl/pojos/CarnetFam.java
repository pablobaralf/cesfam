/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "CARNET_FAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarnetFam.findAll", query = "SELECT c FROM CarnetFam c"),
    @NamedQuery(name = "CarnetFam.findByCodCarnetFam", query = "SELECT c FROM CarnetFam c WHERE c.codCarnetFam = :codCarnetFam"),
    @NamedQuery(name = "CarnetFam.findByColor", query = "SELECT c FROM CarnetFam c WHERE c.color = :color")})
public class CarnetFam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CARNET_FAM")
    private Short codCarnetFam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "COLOR")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carnetFamCodFam")
    private List<Paciente> pacienteList;

    public CarnetFam() {
    }

    public CarnetFam(Short codCarnetFam) {
        this.codCarnetFam = codCarnetFam;
    }

    public CarnetFam(Short codCarnetFam, String color) {
        this.codCarnetFam = codCarnetFam;
        this.color = color;
    }

    public Short getCodCarnetFam() {
        return codCarnetFam;
    }

    public void setCodCarnetFam(Short codCarnetFam) {
        this.codCarnetFam = codCarnetFam;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarnetFam != null ? codCarnetFam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarnetFam)) {
            return false;
        }
        CarnetFam other = (CarnetFam) object;
        if ((this.codCarnetFam == null && other.codCarnetFam != null) || (this.codCarnetFam != null && !this.codCarnetFam.equals(other.codCarnetFam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.CarnetFam[ codCarnetFam=" + codCarnetFam + " ]";
    }
    
}
