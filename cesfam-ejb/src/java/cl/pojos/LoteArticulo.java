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
@Table(name = "LOTE_ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoteArticulo.findAll", query = "SELECT l FROM LoteArticulo l"),
    @NamedQuery(name = "LoteArticulo.findByCodLoteArt", query = "SELECT l FROM LoteArticulo l WHERE l.codLoteArt = :codLoteArt"),
    @NamedQuery(name = "LoteArticulo.findByFechaIngreso", query = "SELECT l FROM LoteArticulo l WHERE l.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "LoteArticulo.findByCantidadInicial", query = "SELECT l FROM LoteArticulo l WHERE l.cantidadInicial = :cantidadInicial")})
public class LoteArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_LOTE_ART")
    private String codLoteArt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_INICIAL")
    private short cantidadInicial;
    @JoinColumn(name = "ARTICULO_COD_ARTICULO", referencedColumnName = "COD_ARTICULO")
    @ManyToOne(optional = false)
    private Articulo articuloCodArticulo;

    public LoteArticulo() {
    }

    public LoteArticulo(String codLoteArt) {
        this.codLoteArt = codLoteArt;
    }

    public LoteArticulo(String codLoteArt, Date fechaIngreso, short cantidadInicial) {
        this.codLoteArt = codLoteArt;
        this.fechaIngreso = fechaIngreso;
        this.cantidadInicial = cantidadInicial;
    }

    public String getCodLoteArt() {
        return codLoteArt;
    }

    public void setCodLoteArt(String codLoteArt) {
        this.codLoteArt = codLoteArt;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public short getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(short cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public Articulo getArticuloCodArticulo() {
        return articuloCodArticulo;
    }

    public void setArticuloCodArticulo(Articulo articuloCodArticulo) {
        this.articuloCodArticulo = articuloCodArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLoteArt != null ? codLoteArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteArticulo)) {
            return false;
        }
        LoteArticulo other = (LoteArticulo) object;
        if ((this.codLoteArt == null && other.codLoteArt != null) || (this.codLoteArt != null && !this.codLoteArt.equals(other.codLoteArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.LoteArticulo[ codLoteArt=" + codLoteArt + " ]";
    }
    
}
