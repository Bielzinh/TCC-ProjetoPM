package controle.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import modelo.dao.SetorDAO;
import modelo.dominio.Setor;


@ManagedBean(name = "setorMB")
@RequestScoped
public class SetorMB {
	

	// receber o código via <f:param >
	@ManagedProperty("#{param.codParam}")
	private String codParam;
	
	private SetorDAO dao = new SetorDAO();
	
	private Setor setor = new Setor();
	
	private List<Setor> setores = null;
		

	public List<Setor> getSetores() {

		if (this.setores == null)
			this.setores = this.dao.lerTodos();

		return setores;
	}


	public String getCodParam() {
		return codParam;
	}


	public void setCodParam(String codParam) {
		this.codParam = codParam;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public void lerSetor() {

		if (codParam != null) {
			try {
				Integer id = Integer.parseInt(this.codParam);
				this.setor = this.dao.lerPorId(id);
			} catch (Exception e) {
			}
		}
	}
	
	public String acaoAbrirAlteracao(Integer id) {

		this.setor = this.dao.lerPorId(id);


		return "editarSetor.jsf";
	}

	public String acaoExcluir(Integer id) {

		this.setor = this.dao.lerPorId(id);

		this.dao.excluir(this.setor);
		
		


		return acaoListar();
		
		
	}
	
	
	
	public String acaoListar() {
		return "editarSetor.jsf?faces-redirect=true";
	}
	
	public String acaoAbrirInclusao() {

		this.setor = new Setor();
		return "editarSetor.jsf";

	}
	
	public String acaoSalvar() {

		this.dao.salvar(this.setor);

		return acaoListar();
	}
	
public String retornarMenu(){
		
		return "Menu.jsf";
	}
	
	

}
