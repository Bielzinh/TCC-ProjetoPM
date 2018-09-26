package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dominio.Policial;
import modelo.dominio.Setor;

public class PolicialDAO extends JpaDAO<Policial> {

	public List<Policial> filtrarPoliciais(String  escala, Setor set, String matricula) {
		String jpql = "from Policial p ";

		if (escala != null) {
			jpql = jpql + " where p.escala = :escal";
		}
		
		else if(set !=null){
			jpql = jpql + "where p.setor= :setor";
		}
		
		else if (matricula != null) {
			jpql = jpql + " where p.matricula like :matricula";
		}

		jpql = jpql + " order by p.matricula";

		TypedQuery<Policial> comando = this.getEntityManager().createQuery(jpql, Policial.class);

		if (escala != null)
			comando.setParameter("escala", escala);
		else if (set != null)
			comando.setParameter("setor", set);
		else if (matricula != null)
			comando.setParameter("matricula", "%" + matricula + "%");

		return comando.getResultList();
	}

}
