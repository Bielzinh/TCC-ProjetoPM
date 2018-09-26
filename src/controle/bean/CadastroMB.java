package controle.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@ManagedBean
@SessionScoped

public class CadastroMB {

	// DAO'S para fazer a persistência
	private UsuarioDAO dao = new UsuarioDAO();

	// Objetos usados nas páginas
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	private String listarUsuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {

		if (this.usuarios == null)
			this.usuarios = this.dao.lerTodos();

		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getListarUsuario() {
		return listarUsuario;
	}

	public void setListarUsuario(String listarUsuario) {
		this.listarUsuario = listarUsuario;
	}

	// métodos
	
	
	public String acaoPesquisar() {

		this.usuarios = this.dao.listarUsuarios(this.listarUsuario);

		return "";
	}

	public void acaoPesquisarAjax(AjaxBehaviorEvent event) {

		this.usuarios = this.dao.listarUsuarios(this.listarUsuario);
	}
	
	

	public String acaoListar() {
		return "listarUsuarios.jsf?faces-redirect=true";

	}

	public String acaoDetalhar() {
		return "";
	}

	public String acaoIncluir() {
		this.usuario = new Usuario();

		return "edicaoUsuario.jsf";
	}

	public String acaoAlterar(String codigo) {

		Integer id = Integer.parseInt(codigo);

		this.usuario = this.dao.lerPorId(id);

		return "edicaoUsuario.jsf";
	}

	public String acaoAdm() {

		return "AcaoAdministrativa.jsf";
	}

	public String acaoSalvar() {
		this.dao.salvar(this.usuario);
		
	
		this.usuarios =  null;
		 
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados gravados com sucesso!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return acaoListar();
	}

	public String acaoExcluir(String codigo) {
		// = null;
		Integer id = Integer.parseInt(codigo);

		this.usuario = this.dao.lerPorId(id);
		// excluir o usuario
		this.dao.excluir(this.usuario);

		// limpar os objetos
		this.usuario = new Usuario();
		this.usuarios = null;

		return acaoListar();
	}
	
	public String retornarConsulta(){
		
		return "listarUsuarios";
		
	}
	
public String retornarLogin(){
		
		return "login.jsf";
		
	}
}
