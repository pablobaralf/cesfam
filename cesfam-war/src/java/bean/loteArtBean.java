/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Articulo;
import cl.pojos.LoteArticulo;
import cl.service.ArticuloFacadeLocal;
import cl.service.LoteArticuloFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@Named(value = "loteArtBean")
@SessionScoped
@ManagedBean
public class loteArtBean implements Serializable {

    @EJB
    private LoteArticuloFacadeLocal loteArticuloFacade;

    @EJB
    private ArticuloFacadeLocal articuloFacade;

  
  private String codLoteArticulo;
  private int cantidadInicial;
  //
  private LoteArticulo loteArticulo;
  private Articulo articulo;
    
    public loteArtBean() {
        loteArticulo = new LoteArticulo();
        articulo = new Articulo();
    }
    
    public List<LoteArticulo> getLotesArticulos(){
        return loteArticuloFacade.findAll();
    }

    public List<Object[]> getStockArticulos(){
        return loteArticuloFacade.stockArticulos();
    }
    
    public String getCodLoteArticulo() {
        return codLoteArticulo;
    }

    public void setCodLoteArticulo(String codLoteArticulo) {
        this.codLoteArticulo = codLoteArticulo;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public LoteArticulo getLoteArticulo() {
        return loteArticulo;
    }

    public void setLoteArticulo(LoteArticulo loteArticulo) {
        this.loteArticulo = loteArticulo;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    public String create(){
       LoteArticulo l = new LoteArticulo();
       l.setArticuloCodArticulo(articuloFacade.find(articulo.getCodArticulo()));
       l.setCodLoteArt(loteArticulo.getCodLoteArt());
       l.setFechaIngreso(new Date());
       l.setCantidadInicial(loteArticulo.getCantidadInicial());
       
       loteArticuloFacade.create(l);
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lote Ingresado, Revise Stock"));

       return "index";
       
    }
    
}
