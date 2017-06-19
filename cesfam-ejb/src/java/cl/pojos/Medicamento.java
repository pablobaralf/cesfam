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
@Table(name = "MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m"),
    @NamedQuery(name = "Medicamento.findByCodMedicamento", query = "SELECT m FROM Medicamento m WHERE m.codMedicamento = :codMedicamento"),
    @NamedQuery(name = "Medicamento.findByDescripcionMedicamento", query = "SELECT m FROM Medicamento m WHERE m.descripcionMedicamento = :descripcionMedicamento"),
    @NamedQuery(name = "Medicamento.findByPrincipioActivo", query = "SELECT m FROM Medicamento m WHERE m.principioActivo = :principioActivo"),
    @NamedQuery(name = "Medicamento.findByComponentes", query = "SELECT m FROM Medicamento m WHERE m.componentes = :componentes"),
    @NamedQuery(name = "Medicamento.findByContenido", query = "SELECT m FROM Medicamento m WHERE m.contenido = :contenido"),
    @NamedQuery(name = "Medicamento.findByGramaje", query = "SELECT m FROM Medicamento m WHERE m.gramaje = :gramaje")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_MEDICAMENTO")
    private Long codMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DESCRIPCION_MEDICAMENTO")
    private String descripcionMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PRINCIPIO_ACTIVO")
    private String principioActivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COMPONENTES")
    private String componentes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTENIDO")
    private short contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRAMAJE")
    private short gramaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentoCodMedicamento")
    private List<LoteMedicamento> loteMedicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentoCodMedicamento")
    private List<Caducidad> caducidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentoCodMedicamento")
    private List<Detalle> detalleList;
    @JoinColumn(name = "FABRICANTE_COD_FABRICANTE", referencedColumnName = "COD_FABRICANTE")
    @ManyToOne(optional = false)
    private Fabricante fabricanteCodFabricante;
    @JoinColumn(name = "TIPO_COD_TIPO", referencedColumnName = "COD_TIPO")
    @ManyToOne(optional = false)
    private Tipo tipoCodTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentoCodMedicamento")
    private List<Reserva> reservaList;

    public Medicamento() {
    }

    public Medicamento(Long codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public Medicamento(Long codMedicamento, String descripcionMedicamento, String principioActivo, String componentes, short contenido, short gramaje) {
        this.codMedicamento = codMedicamento;
        this.descripcionMedicamento = descripcionMedicamento;
        this.principioActivo = principioActivo;
        this.componentes = componentes;
        this.contenido = contenido;
        this.gramaje = gramaje;
    }

    public Long getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(Long codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public String getDescripcionMedicamento() {
        return descripcionMedicamento;
    }

    public void setDescripcionMedicamento(String descripcionMedicamento) {
        this.descripcionMedicamento = descripcionMedicamento;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public short getContenido() {
        return contenido;
    }

    public void setContenido(short contenido) {
        this.contenido = contenido;
    }

    public short getGramaje() {
        return gramaje;
    }

    public void setGramaje(short gramaje) {
        this.gramaje = gramaje;
    }

    @XmlTransient
    public List<LoteMedicamento> getLoteMedicamentoList() {
        return loteMedicamentoList;
    }

    public void setLoteMedicamentoList(List<LoteMedicamento> loteMedicamentoList) {
        this.loteMedicamentoList = loteMedicamentoList;
    }

    @XmlTransient
    public List<Caducidad> getCaducidadList() {
        return caducidadList;
    }

    public void setCaducidadList(List<Caducidad> caducidadList) {
        this.caducidadList = caducidadList;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    public Fabricante getFabricanteCodFabricante() {
        return fabricanteCodFabricante;
    }

    public void setFabricanteCodFabricante(Fabricante fabricanteCodFabricante) {
        this.fabricanteCodFabricante = fabricanteCodFabricante;
    }

    public Tipo getTipoCodTipo() {
        return tipoCodTipo;
    }

    public void setTipoCodTipo(Tipo tipoCodTipo) {
        this.tipoCodTipo = tipoCodTipo;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMedicamento != null ? codMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.codMedicamento == null && other.codMedicamento != null) || (this.codMedicamento != null && !this.codMedicamento.equals(other.codMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Medicamento[ codMedicamento=" + codMedicamento + " ]";
    }
    
}
