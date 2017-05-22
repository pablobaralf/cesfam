/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Articulo;
import cl.pojos.Fabricante;
import cl.pojos.Tipo;
import cl.service.ArticuloFacadeLocal;
import cl.service.FabricanteFacadeLocal;
import cl.service.TipoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "articuloBean")
@SessionScoped
@ManagedBean
public class articuloBean {

     @EJB
    private FabricanteFacadeLocal fabricanteFacade;

    @EJB
    private TipoFacadeLocal tipoFacade;

    @EJB
    private ArticuloFacadeLocal articuloFacade;

     public int codArticulo;
    public String descripcionArticulo;
    public String uso;
//
    public Articulo articulo;
    public Fabricante fabricante;
    public Tipo tipo;

    public articuloBean() {

        articulo = new Articulo();
        fabricante = new Fabricante();
        tipo = new Tipo();
        
    }
    
    public List<Articulo> getArticulos(){
        return articuloFacade.findAll();
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public String create(){
        Articulo a = new Articulo();
        a.setCodArticulo(articulo.getCodArticulo());
        a.setDescripcionArticulo(articulo.getDescripcionArticulo());
        a.setUso(articulo.getUso());     
        articuloFacade.create(a);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Artículo creado"));

        return "index";    
    }
    
}
