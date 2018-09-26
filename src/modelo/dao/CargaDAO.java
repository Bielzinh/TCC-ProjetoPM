package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dominio.Carga;
import modelo.dominio.Materialbelico;

public class CargaDAO extends JpaDAO<Carga> {

	public List<Carga> filtrarCargas(String dt_retirada, String matricula) {
		String jpql = "from Carga p ";

		 if (dt_retirada != null) {
			jpql = jpql + " where p.dt_retirada like :dt_retirada";
		}

		 else if (matricula != null) {
				jpql = jpql + " where p.matricula like :matricula";
			}

		jpql = jpql + " order by p.matricula";

		TypedQuery<Carga> comando = this.getEntityManager().createQuery(jpql, Carga.class);

		if (dt_retirada != null)
			comando.setParameter("dt_retirada", "%" + dt_retirada + "%");
		else if (matricula != null)
			comando.setParameter("matricula", matricula);


		return comando.getResultList();
	}
	
	
	

}
