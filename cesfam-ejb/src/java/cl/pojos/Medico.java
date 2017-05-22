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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MEDICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByCodMedico", query = "SELECT m FROM Medico m WHERE m.codMedico = :codMedico")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_MEDICO")
    private String codMedico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoCodMedico")
    private List<Prescripcion> prescripcionList;
    @JoinColumn(name = "RUT", referencedColumnName = "RUT")
    @ManyToOne(optional = false)
    private Usuario rut;

    public Medico() {
    }

    public Medico(String codMedico) {
        this.codMedico = codMedico;
    }

    public String getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(String codMedico) {
        this.codMedico = codMedico;
    }

    @XmlTransient
    public List<Prescripcion> getPrescripcionList() {
        return prescripcionList;
    }

    public void setPrescripcionList(List<Prescripcion> prescripcionList) {
        this.prescripcionList = prescripcionList;
    }

    public Usuario getRut() {
        return rut;
    }

    public void setRut(Usuario rut) {
        this.rut = rut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMedico != null ? codMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.codMedico == null && other.codMedico != null) || (this.codMedico != null && !this.codMedico.equals(other.codMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Medico[ codMedico=" + codMedico + " ]";
    }
    
}
