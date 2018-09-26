package controle.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.dao.HistoricoDAO;
import modelo.dominio.Historico;

@ManagedBean(name = "historicoMB")
public class HistoricoMB {
	
	private Historico historico = new Historico();
	private HistoricoDAO dao = new HistoricoDAO();
	private List<Historico> historicos = null;
	

	
    
	
	public List<Historico> getHistoricos() {
		
		
		if (this.historicos == null)
			this.historicos = this.dao.lerTodos();
		


		return historicos;
	}
	
	
	
	
	
	public HistoricoDAO getDao() {
		return dao;
	}
	public void setDao(HistoricoDAO dao) {
		this.dao = dao;
	}
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}





	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
	
	


	

}
