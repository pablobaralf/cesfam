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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f"),
    @NamedQuery(name = "Formulario.findByCodFormulario", query = "SELECT f FROM Formulario f WHERE f.codFormulario = :codFormulario")})
public class Formulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_FORMULARIO")
    private String codFormulario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formularioCodFormulario")
    private List<EvaluacionMed> evaluacionMedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formularioCodFormulario")
    private List<Entrega> entregaList;
    @JoinColumn(name = "CARNET_COD_CARNET", referencedColumnName = "COD_CARNET")
    @OneToOne(optional = false)
    private Carnet carnetCodCarnet;

    public Formulario() {
    }

    public Formulario(String codFormulario) {
        this.codFormulario = codFormulario;
    }

    public String getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(String codFormulario) {
        this.codFormulario = codFormulario;
    }

    @XmlTransient
    public List<EvaluacionMed> getEvaluacionMedList() {
        return evaluacionMedList;
    }

    public void setEvaluacionMedList(List<EvaluacionMed> evaluacionMedList) {
        this.evaluacionMedList = evaluacionMedList;
    }

    @XmlTransient
    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    public Carnet getCarnetCodCarnet() {
        return carnetCodCarnet;
    }

    public void setCarnetCodCarnet(Carnet carnetCodCarnet) {
        this.carnetCodCarnet = carnetCodCarnet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormulario != null ? codFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.codFormulario == null && other.codFormulario != null) || (this.codFormulario != null && !this.codFormulario.equals(other.codFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Formulario[ codFormulario=" + codFormulario + " ]";
    }
    
}
