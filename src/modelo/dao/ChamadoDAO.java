package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dominio.Chamado;
import modelo.dominio.Setor;

public class ChamadoDAO extends JpaDAO<Chamado> {

	public List<Chamado> filtrarChamados(Setor set, String status) {
		String jpql = "from Chamado p ";

		
		 if(set !=null){
			jpql = jpql + "where p.setor= :setor";
		}
		 
		 else if (status != null) {
				jpql = jpql + " where p.status like :status";
			}

		
		
		jpql = jpql + " order by p.setor";

		TypedQuery<Chamado> comando = this.getEntityManager().createQuery(jpql, Chamado.class);
        
		if (set != null)
			comando.setParameter("setor", set);
		else if (status != null)
			comando.setParameter("status", "%" + status + "%");
		
		return comando.getResultList();
	}

}
