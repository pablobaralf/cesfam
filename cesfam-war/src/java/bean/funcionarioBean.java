/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Funcionario;
import cl.pojos.Usuario;
import cl.service.FuncionarioFacadeLocal;
import cl.service.UsuarioFacadeLocal;
import java.io.File;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JFileChooser;
import java.util.List;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Dany
 */
@Named(value = "funcionarioBean")
@SessionScoped
public class funcionarioBean  implements Serializable{

    @EJB
    private FuncionarioFacadeLocal funcionarioFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private String txtruta;
    private String codFuncionario;
    private String rut;

    private Funcionario funcionario;
    private Usuario usuario;

    public funcionarioBean() {
        funcionario = new Funcionario();
        usuario = new Usuario();

    }
    
    public List<Funcionario> getFuncionarios(){
        return funcionarioFacade.findAll();
    }

    public String getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(String codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTxtruta() {
        return txtruta;
    }

    public void setTxtruta(String txtruta) {
        this.txtruta = txtruta;
    }

       public String iniciarSesionFuncionario() {
        Funcionario f;
        try {
            f = funcionarioFacade.iniciarSesionFuncionario(funcionario, usuario);
            if (f != null) {
                //Guardar usuario logeado en la sesión
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionario", f);
                return "indexFuncionario";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Incorrecto", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Fallido", ""));

        }

        return null;
    }
    
      public static Funcionario verificarSesion() {
        try {
            //Retornar usuario logeado para operaciones
            Funcionario fun = (Funcionario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("funcionario");

            if (fun == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                return null;

            } else {
                return fun;
            }

        } catch (Exception e) {
            return null;

        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }

    public void guardarInforme() {
        JFileChooser dlg = new JFileChooser();
        int option = dlg.showSaveDialog(dlg);
        if (option == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
            txtruta = f.toString();

        }

    }
    
        public String insertarFuncionario() {
        funcionarioFacade.insertarFuncionario(funcionario,usuario);
        return "index";

    }

}
