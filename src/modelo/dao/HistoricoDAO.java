package modelo.dao;


import javax.persistence.TypedQuery;

import modelo.dominio.Historico;

public class HistoricoDAO extends JpaDAO<Historico> {
	

	
	
	public Historico obterMarket()
	{
		String jpql = "from Historico h";
		
		jpql = jpql + " order by h.idHistorico DESC";


		TypedQuery<Historico> comando = this.getEntityManager().createQuery(jpql, Historico.class);
        comando.setMaxResults(1);
		return  comando.getSingleResult();
	}
	
	public Historico obterData(){
		String jpql = "from Historico h";

		
		TypedQuery<Historico> comando = this.getEntityManager().createQuery(jpql, Historico.class);
		return  comando.getSingleResult();

		
	}
	
	

	}

	

	
	

