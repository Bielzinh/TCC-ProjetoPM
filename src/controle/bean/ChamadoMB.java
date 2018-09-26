package controle.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.ChamadoDAO;
import modelo.dao.SetorDAO;
import modelo.dominio.Chamado;
import modelo.dominio.Setor;

@ManagedBean(name = "chamadoMB")
@RequestScoped
public class ChamadoMB {
	
	

private ChamadoDAO dao = new ChamadoDAO();
	
	private Chamado chamado = new Chamado();
	
	private List<Chamado> chamados = null;
	
	private String filtroStatus;

	private Setor  filtroSetor;

	private List<Setor> setores = null;
	
	// receber o código via <f:param >
		@ManagedProperty("#{param.codParam}")
		private String codParam;
		
	
	
	
	public List<Setor> getSetores() {

		if (this.setores == null)
			this.setores = new SetorDAO().lerTodos();

		return setores;
	}

	public List<Chamado> getChamados() {

		if (this.chamados == null)
			this.chamados = this.dao.lerTodos();

		return chamados;
	}

	
	
	
	


public String getFiltroStatus() {
		return filtroStatus;
	}

	public void setFiltroStatus(String filtroStatus) {
		this.filtroStatus = filtroStatus;
	}

public String acaoPesquisar() {
		
		this.chamados = this.dao.filtrarChamados(filtroSetor,filtroStatus);

		return "chamadoAberto.jsf";
	}
	


	public String getCodParam() {
	return codParam;
}

public void setCodParam(String codParam) {
	this.codParam = codParam;
}

	public Setor getFiltroSetor() {
		return filtroSetor;
	}

	public void setFiltroSetor(Setor filtroSetor) {
		this.filtroSetor = filtroSetor;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public Chamado getChamado() {
		return chamado;
	}




	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}




	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public String acaoAbrirAlteracao(Integer id) {

		this.chamado = dao.lerPorId(id);

		return "abrirChamado.jsf";
	}


	public String acaoExcluir(Integer id) {

		this.chamado = dao.lerPorId(id);

		this.dao.excluir(this.chamado);

		return acaoListar();
	}
	
	public String acaoListar() {
		return "editarChamado.jsf?faces-redirect=true";
	}
	
	public String acaoAbrirInclusao() {

		this.chamado = new Chamado();
		return "editarChamado";

	}
	
	public String acaoSalvar() {

		this.dao.salvar(this.chamado);

		return "chamadoAberto.jsf";
	}
	
public String retornarMenu(){
		
		return "Menu.jsf";
	}

public String acaoCancelar() {

	return "Menu.jsf";
}

public void lerChamado() {

	if (codParam != null) {
		try {
			Integer id = Integer.parseInt(this.codParam);
			this.chamado = this.dao.lerPorId(id);
		} catch (Exception e) {
		}
	}
}
}
