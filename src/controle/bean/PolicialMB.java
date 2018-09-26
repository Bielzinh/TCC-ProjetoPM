package controle.bean;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import modelo.dao.PolicialDAO;
import modelo.dao.SetorDAO;
import modelo.dominio.Policial;
import modelo.dominio.Setor;

@ManagedBean(name = "policialMB")
@RequestScoped
public class PolicialMB implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private String filtroMatricula;
	private String filtroEscala;
	private Setor  filtroSetor;
	private HtmlInputText campoMatricula;
	private UploadedFile uploadedFile;
	private String cep = null;
	private String tipoLogradouro;
	private String logradouro;
	private String estado;
	private String cidade;
	private String bairro;
	
	// receber o código via <f:param >
	@ManagedProperty("#{param.codParam}")
	private String codParam;
	
	private Policial policial = new Policial();

	private PolicialDAO dao = new PolicialDAO();
	
	
	
	private List<Policial> policiais = null;
	
	
	private List<Setor> setores = null;
	

	public String getContador()
	{
		String matricula = this.policial.getMatricula();
		if (matricula == null)
			return "0";
		
		return String.valueOf(matricula.length());
	}
	
	
	
	public List<Policial> getPoliciais() {

		if (this.policiais == null)
			this.policiais = this.dao.lerTodos();

		return policiais;
	}
    
	
	
	public List<Setor> getSetores() {

		if (this.setores == null)
			this.setores = new SetorDAO().lerTodos();

		return setores;
	}
	
	
	
	
	
	
	

	

	

	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getTipoLogradouro() {
		return tipoLogradouro;
	}



	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}



	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}



	public HtmlInputText getCampoMatricula() {
		return campoMatricula;
	}



	public void setCampoMatricula(HtmlInputText campoMatricula) {
		this.campoMatricula = campoMatricula;
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



	public String getFiltroMatricula() {
		return filtroMatricula;
	}

	public void setFiltroMatricula(String filtroMatricula) {
		this.filtroMatricula = filtroMatricula;
	}

	

	public Policial getPolicial() {
		return policial;
	}




	public String getFiltroEscala() {
		return filtroEscala;
	}



	public void setFiltroEscala(String filtroEscala) {
		this.filtroEscala = filtroEscala;
	}



	public void setPolicial(Policial policial) {
		this.policial = policial;
	}

	public String acaoListar() {
		return "consultarPolicial.jsf?faces-redirect=true";
	}

	public String acaoPesquisar() {
		
		this.policiais = this.dao.filtrarPoliciais(filtroEscala, filtroSetor,filtroMatricula);

		return "consultarPolicial.jsf";
	}
	
public String acaoPesquisar1() {
		
		this.policiais = this.dao.filtrarPoliciais(filtroEscala, filtroSetor,filtroMatricula);

		return "adicionarCarga1.jsf";
	}
	
public String acaoPesquisar3() {
	
	this.policiais = this.dao.filtrarPoliciais(filtroEscala, filtroSetor,filtroMatricula);

	return "FinalizarCarga1.jsf";
}
	public void lerPolicial() {

		if (codParam != null) {
			try {
				Integer id = Integer.parseInt(this.codParam);
				this.policial = this.dao.lerPorId(id);
			} catch (Exception e) {
			}
		}
	}
	
	public String acaoAbrirAlteracao(Integer codigo) {

		this.policial = dao.lerPorId(codigo);


		return "editarPolicial.jsf";
	}

	public String acaoExcluir(Integer codigo) {

		this.policial = dao.lerPorId(codigo);

		this.dao.excluir(this.policial);

		return acaoListar();
	}
	public String acaoAbrirInclusao() {

		this.policial = new Policial();
		return "editarPolicial.jsf";

	}
	

	public String acaoSalvar() {

		// recupera os bytes da foto
		byte[] foto = this.uploadedFile.getContents();

		if (foto != null && foto.length > 0)
			this.policial.setFoto(foto);

		this.dao.salvar(this.policial);

		return acaoListar();
	}
	

	public String retornarMenu(){
		
		return "Menu.jsf";
	}
	
public String retornarConsulta(){
		
		return "consultarPolicial.jsf";
	}

public void download() throws IOException {

	FacesContext contexto = FacesContext.getCurrentInstance();
	ExternalContext external = contexto.getExternalContext();
	OutputStream saida = external.getResponseOutputStream();

	String codigo = external.getRequestParameterMap().get("codigo");

	// limpa qualquer resposta que tenha sido colocada no cache
	external.responseReset();
	// indica o tipo de conteúdo retornado
	external.setResponseContentType("image/jpeg");
	// indica qual o nome do arquivo
	external.setResponseHeader("Content-Disposition", "inline; filename=foto-" + codigo + ".jpg");
	// indica que não deve guardar cache da imagem no browser
	external.setResponseHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	external.setResponseHeader("Pragma", "no-cache"); // HTTP 1.0
	external.setResponseHeader("Expires", "0"); // Proxies.

	Integer id = null;
	Policial poli = null;
	try {
		id = Integer.parseInt(codigo);
		// lê o produto do banco
		poli = dao.lerPorId(id);
	} catch (Exception e) {
	}

	if (poli != null) {
		byte[] foto = poli.getFoto();

		if (foto != null) {
			// define o tamanho da resposta
			external.setResponseContentLength(foto.length);
			// descarrega os bytes na resposta
			saida.write(foto);
		}
	}
	// indica ao JSF que o processamento foi completado e ele deve finalizar
	contexto.responseComplete();
}
public void encontraCEP() {
	Policial Policial = new Policial(getCep());

	if (Policial.getResultado() == 1) {
		setTipoLogradouro(Policial.getTipoLogradouro());
		setLogradouro(Policial.getLogradouro());
		setEstado(Policial.getEstado());
		setCidade(Policial.getCidade());
		setBairro(Policial.getBairro());
	} else {

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Servidor não está respondendo",
						"Servidor não está respondendo"));
	}
}
}
