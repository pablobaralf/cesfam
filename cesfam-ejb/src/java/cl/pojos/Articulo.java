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
@Table(name = "ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByCodArticulo", query = "SELECT a FROM Articulo a WHERE a.codArticulo = :codArticulo"),
    @NamedQuery(name = "Articulo.findByDescripcionArticulo", query = "SELECT a FROM Articulo a WHERE a.descripcionArticulo = :descripcionArticulo"),
    @NamedQuery(name = "Articulo.findByUso", query = "SELECT a FROM Articulo a WHERE a.uso = :uso")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ARTICULO")
    private Long codArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DESCRIPCION_ARTICULO")
    private String descripcionArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USO")
    private String uso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloCodArticulo")
    private List<LoteArticulo> loteArticuloList;

    public Articulo() {
    }

    public Articulo(Long codArticulo) {
        this.codArticulo = codArticulo;
    }

    public Articulo(Long codArticulo, String descripcionArticulo, String uso) {
        this.codArticulo = codArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.uso = uso;
    }

    public Long getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(Long codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @XmlTransient
    public List<LoteArticulo> getLoteArticuloList() {
        return loteArticuloList;
    }

    public void setLoteArticuloList(List<LoteArticulo> loteArticuloList) {
        this.loteArticuloList = loteArticuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArticulo != null ? codArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.codArticulo == null && other.codArticulo != null) || (this.codArticulo != null && !this.codArticulo.equals(other.codArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Articulo[ codArticulo=" + codArticulo + " ]";
    }
    
}
