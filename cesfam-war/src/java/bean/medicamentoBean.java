package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cl.pojos.Fabricante;
import cl.pojos.Medicamento;
import cl.pojos.Tipo;
import cl.service.FabricanteFacadeLocal;
import cl.service.LoteMedicamentoFacadeLocal;
import cl.service.MedicamentoFacadeLocal;
import cl.service.TipoFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Dany
 */
@Named(value = "medicamentoBean")
@SessionScoped
@ManagedBean
public class medicamentoBean {

    @EJB
    private LoteMedicamentoFacadeLocal loteMedicamentoFacade;

    @EJB
    private FabricanteFacadeLocal fabricanteFacade;

    @EJB
    private TipoFacadeLocal tipoFacade;

    @EJB
    private MedicamentoFacadeLocal medicamentoFacade;

    private Medicamento medicamento;

    private int codMedicamento;
    private String descripcion;
    private String principioActivo;
    private String componentes;
    private int contenido;
    private int gramaje;

    private Tipo tipo;
    private Fabricante fabricante;

    public medicamentoBean() {
        medicamento = new Medicamento();
        tipo = new Tipo();
        fabricante = new Fabricante();

    }

    public List<Medicamento> getMedicamentos() {

        return medicamentoFacade.findAll();

    }

    public List<Object[]> getListaMedicamentos() {
        return loteMedicamentoFacade.stockMedicamentos();
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getGramaje() {
        return gramaje;
    }

    public void setGramaje(int gramaje) {
        this.gramaje = gramaje;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String create() {
        Medicamento m = new Medicamento();
        m.setCodMedicamento(medicamento.getCodMedicamento());
        m.setDescripcionMedicamento(medicamento.getDescripcionMedicamento());
        m.setPrincipioActivo(medicamento.getPrincipioActivo());
        m.setComponentes(medicamento.getComponentes());
        m.setContenido(medicamento.getContenido());
        m.setGramaje(medicamento.getGramaje());
        m.setTipoCodTipo(tipoFacade.find(tipo.getCodTipo()));
        m.setFabricanteCodFabricante(fabricanteFacade.find(fabricante.getCodFabricante()));
        medicamentoFacade.create(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medicamento registrado en el sistema"));
        return "index";

    }

    JasperPrint jasperPrint;

    public void init() throws JRException {
        JRBeanCollectionDataSource beanCollectionDatasource = new JRBeanCollectionDataSource(getListaMedicamentos());
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reports/reportMedicamentos.jasper"));
        jasperPrint = JasperFillManager.fillReport(jasper.getPath(), new HashMap(), beanCollectionDatasource);
    }

    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        init();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }

}
