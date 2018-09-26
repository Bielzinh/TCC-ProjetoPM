package controle.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.MaterialbelicoDAO;
import modelo.dominio.Materialbelico;

@ManagedBean(name = "materialbelicoMB")
@RequestScoped
public class MaterialbelicoMB implements Serializable{
	private static final long serialVersionUID = 1L;
    
	// receber o código via <f:param >
	@ManagedProperty("#{param.codParam}")
	private String codParam;
	
	
	private String filtroNm_serie;
	
	private String filtroTipomaterial;
	
	private Materialbelico materialbelico = new Materialbelico();

	
	private MaterialbelicoDAO dao = new MaterialbelicoDAO();
	
	
	private List<Materialbelico> materialbelicos = null;

		

	
	
	
	
	
	public List<Materialbelico> getMaterialbelicos() {

		if (this.materialbelicos == null)
			this.materialbelicos = this.dao.lerTodos();

		return materialbelicos;
	}
    
	
	
	
	
public String getFiltroTipomaterial() {
		return filtroTipomaterial;
	}





	public void setFiltroTipomaterial(String filtroTipomaterial) {
		this.filtroTipomaterial = filtroTipomaterial;
	}





public String getFiltroNm_serie() {
		return filtroNm_serie;
	}





	public void setFiltroNm_serie(String filtroNm_serie) {
		this.filtroNm_serie = filtroNm_serie;
	}





public String getCodParam() {
		return codParam;
	}





	public void setCodParam(String codParam) {
		this.codParam = codParam;
	}





public Materialbelico getMaterialbelico() {
		return materialbelico;
	}



	public void setMaterialbelico(Materialbelico materialbelico) {
		this.materialbelico = materialbelico;
	}




	public void setMaterialbelicos(List<Materialbelico> materialbelicos) {
		this.materialbelicos = materialbelicos;
	}

public String acaoPesquisar() {
		
		this.materialbelicos = this.dao.filtrarMaterialbelicos(filtroNm_serie, filtroTipomaterial);

		return "consultarMaterialBelico.jsf";
	}

public String acaoPesquisar1() {
	
	this.materialbelicos = this.dao.filtrarMaterialbelicos(filtroNm_serie, filtroTipomaterial);

	return acaoListar1();
}


public void lerMaterialbelico() {

	if (codParam != null) {
		try {
			Integer id = Integer.parseInt(this.codParam);
			this.materialbelico = this.dao.lerPorId(id);
		} catch (Exception e) {
		}
	}
}


	public String acaoAbrirAlteracao(Integer id) {

		this.materialbelico = dao.lerPorId(id);

		return "editarMaterialBelico.jsf";
	}

	public String acaoExcluir(Integer id) {

		this.materialbelico = dao.lerPorId(id);

		this.dao.excluir(this.materialbelico);

		return acaoListar();
	}



	public String acaoListar() {
		return "consultarMaterialBelico.jsf?faces-redirect=true";
	}


	public String acaoListar1() {
		return "adicionarCarga2.jsf?faces-redirect=true";
	}


	public String acaoAbrirInclusao() {

		this.materialbelico = new Materialbelico();
		return "home.jsf";

	}
	
	public String Salvoo(){
		
		
		return codParam;
		
		
		
	}
	
	public String acaoSalvar() {

		this.dao.salvar(this.materialbelico);

		return "consultarMaterialBelico.jsf";
	}

	public String retornarMenu(){
		
		return "Menu.jsf";
	}
	
public String retornarConsulta(){
		
		return "consultarMaterialBelico.jsf";
	}



	
}
