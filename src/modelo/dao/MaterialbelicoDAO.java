package modelo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.dominio.Carga;
import modelo.dominio.Materialbelico;
import modelo.dominio.Usuario;


public class MaterialbelicoDAO extends JpaDAO<Materialbelico> {

	public List<Materialbelico> filtrarMaterialbelicos(String nm_serie, String tipoMaterial) {
		String jpql = "from Materialbelico p ";

		if (nm_serie != null) {
			jpql = jpql + " where p.nm_serie = :nm_serie";
		}
	
		else if (tipoMaterial != null) {
			jpql = jpql + " where p.tipoMaterial like :tipoMaterial";
		}

		jpql = jpql + " order by p.tipoMaterial";

		TypedQuery<Materialbelico> comando = this.getEntityManager().createQuery(jpql, Materialbelico.class);

		if (nm_serie != null)
			comando.setParameter("nm_serie", nm_serie);
		else if (tipoMaterial != null)
			comando.setParameter("tipoMaterial", tipoMaterial);

		return comando.getResultList();
	}
	
	public Materialbelico obterMaterial(String nm_serie)
	{
		String jpql = "from Materialbelico p  where p.nm_serie = :nm_serie";
	
		TypedQuery<Materialbelico> comando = this.getEntityManager().createQuery(jpql, Materialbelico.class);
		comando.setParameter("nm_serie", nm_serie);

		return comando.getSingleResult();
	}
	
	public Materialbelico obterStatus(String status)
	{
		String jpql = "from Materialbelico p  where p.status = :status";
	
		TypedQuery<Materialbelico> comando = this.getEntityManager().createQuery(jpql, Materialbelico.class);
		comando.setParameter("status", status);

		return comando.getSingleResult();
	}
	
	/*
	public  Materialbelico Disponibilidade(){
		
		Materialbelico resultado = null;
		Materialbelico m = new Materialbelico();
		Carga c = new Carga();
		String jpql = "from Materialbelico p ";	
		
		Query consulta = this.getEntityManager().createQuery("from Materialbelico p ");
		
		try{
			
			resultado = (Materialbelico) consulta.getSingleResult();

		}catch(Exception e){
			
		}
		if(resultado != null){
			
			if(c.getQuantidade() == m.getNm_serie())
				jpql = jpql + "UPDATE tab_materialbelico SET status = 'OCUPADO' ";
				
		}
		
			
		return resultado;

		}
		
		
		*/
		
		
		
	}


