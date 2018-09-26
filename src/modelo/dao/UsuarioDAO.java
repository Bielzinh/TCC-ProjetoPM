package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.dominio.Usuario;


public class UsuarioDAO extends JpaDAO<Usuario> {
	
	public List<Usuario> filtrarUsuarios(String nome)
	{
		String comando = "from Usuario u  where u.nome like :nome  order by u.nome";
		TypedQuery<Usuario> query = this.getEntityManager().createQuery(comando, Usuario.class);
		query.setParameter("nome", "%" + nome+ "%");
		
		return query.getResultList();
	}
	
	
	
	
	
	
	public List<Usuario> listarUsuarios(String nome)
	{
		String comando = "from Usuario u  where u.nome like :nome  order by u.nome";
		TypedQuery<Usuario> query = this.getEntityManager().createQuery(comando, Usuario.class);
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}	
	
	
	
	
	public UsuarioDAO()
	{
		super();
	}

	public UsuarioDAO(EntityManager manager)
	{
		super(manager);
	}

	public Usuario lerPorLogin(String login)
	{
		Usuario resultado;

		Query consulta = this.getEntityManager().createQuery("from Usuario u where u.login = :login");
		consulta.setParameter("login", login);

		try
		{
			resultado = (Usuario) consulta.getSingleResult();
		}
		catch (NoResultException e)
		{
			resultado = null;
		}

		return resultado;
	}
	
	/*
	public List<Usuario>obterTodos(){
		TypedQuery<Usuario> query = this.manager.createQuery("from Usuario",Usuario.class);
		
		return  query.getResultList();
		
	}
	*/
	
	
}
