package controle.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import controle.util.JSFUtil;
import modelo.dao.CargaDAO;
import modelo.dao.MaterialbelicoDAO;
import modelo.dominio.Carga;
import modelo.dominio.Materialbelico;

@ManagedBean(name = "cargaMB")
@RequestScoped
public class CargaMB {

	private String filtroData;
	private String filtromat;

	private CargaDAO dao = new CargaDAO();
	private MaterialbelicoDAO daoMat = new MaterialbelicoDAO();

	private Carga carga = new Carga();

	private Materialbelico matee = new Materialbelico();

	private List<Carga> cargas = null;

	private List<Materialbelico> materialbelicos = null;

	public List<Materialbelico> getMaterialbelicos() {

		if (this.materialbelicos == null)
			this.materialbelicos = new MaterialbelicoDAO().lerTodos();

		return materialbelicos;
	}

	public List<Carga> getCargas() {

		if (this.cargas == null)
			this.cargas = this.dao.lerTodos();

		return cargas;
	}
	
	

	public String getFiltromat() {
		return filtromat;
	}

	public void setFiltromat(String filtromat) {
		this.filtromat = filtromat;
	}

	public String getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(String filtroData) {
		this.filtroData = filtroData;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public void setMaterialbelicos(List<Materialbelico> materialbelicos) {
		this.materialbelicos = materialbelicos;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public String acaoAbrirInclusao() {

		this.carga = new Carga();
		return "adicionarCarga";

	}

	public String acaoAbrirAlteracao(Integer id) {

		this.carga = this.dao.lerPorId(id);

		return "adicionarCarga1.jsf";
	}

	public String acaoExcluir(Integer id) {

		this.carga = this.dao.lerPorId(id);

		this.dao.excluir(this.carga);

		return "RelatorioCargas";

	}



	public String acaoSalvar1() {

		// salvar a carga
		this.dao.salvar(this.carga);

		// buscar o material com a mesma serie
		Materialbelico mat = this.daoMat.obterMaterial(this.carga.getSerie());

		if (mat != null) {
			if ("OCUPADO".equals(mat.getStatus())) {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "MATERIAL EM USO!", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "adicionarCarga1";

			} else if ("DISPONIVEL".equals(mat.getStatus())) {

				mat.setStatus("OCUPADO");
				this.daoMat.salvar(mat);
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CARGA ADICIONADA COM SUCESSO!", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "adicionarCarga1";

			}
		}
		return "RelatorioCargas.jsf";

	}
	public String devolver(){
		
		Materialbelico mat = this.daoMat.obterMaterial(this.carga.getSerie());

		if (mat != null) {

		mat.setStatus("DISPONIVEL");
		this.daoMat.salvar(mat);
		
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "MATERIAL DEVOLVIDO COM SUCESSO!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
		return"FinalizaCarga3";
	}
	
	

	public String acaoPesquisar() {

		this.cargas = this.dao.filtrarCargas(filtroData, filtromat);

		return "RelatorioCargas"; 
	}
	
	public String acaoPesquisar2() {

		this.cargas = this.dao.filtrarCargas(filtroData, filtromat);

		return "FinalizarCarga3"; 
	}

	public String retornarMenu() {

		return "Menu.jsf";
	}

	public String acaoCancelar() {

		return "Menu.jsf";
	}

	public String retornarConsulta() {

		return "RelatorioCargas";
	}

}
