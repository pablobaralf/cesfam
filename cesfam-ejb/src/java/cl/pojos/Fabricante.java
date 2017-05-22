/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "FABRICANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByCodFabricante", query = "SELECT f FROM Fabricante f WHERE f.codFabricante = :codFabricante"),
    @NamedQuery(name = "Fabricante.findByDescripcionFabricante", query = "SELECT f FROM Fabricante f WHERE f.descripcionFabricante = :descripcionFabricante")})
public class Fabricante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FABRICANTE")
    private Short codFabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DESCRIPCION_FABRICANTE")
    private String descripcionFabricante;

    public Fabricante() {
    }

    public Fabricante(Short codFabricante) {
        this.codFabricante = codFabricante;
    }

    public Fabricante(Short codFabricante, String descripcionFabricante) {
        this.codFabricante = codFabricante;
        this.descripcionFabricante = descripcionFabricante;
    }

    public Short getCodFabricante() {
        return codFabricante;
    }

    public void setCodFabricante(Short codFabricante) {
        this.codFabricante = codFabricante;
    }

    public String getDescripcionFabricante() {
        return descripcionFabricante;
    }

    public void setDescripcionFabricante(String descripcionFabricante) {
        this.descripcionFabricante = descripcionFabricante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFabricante != null ? codFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.codFabricante == null && other.codFabricante != null) || (this.codFabricante != null && !this.codFabricante.equals(other.codFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Fabricante[ codFabricante=" + codFabricante + " ]";
    }
    
}
