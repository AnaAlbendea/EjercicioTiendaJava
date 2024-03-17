package es.getafe.examen.persistencia;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Fabricante;


public class FabricanteDaoImpl implements FabricanteDao {
	private EntityManager em;

	@Override
	public void save(Fabricante fabricante) {
	em=EMF.getInstance().createEntityManager();
	  em.getTransaction().begin();
	  em.merge(fabricante);
	  em.getTransaction().commit();
	  em.close();
	
		
	}

	@Override
	public Fabricante findByIdLazy(int idFabricante) {
	em=EMF.getInstance().createEntityManager();
	  Fabricante buscado=em.find(Fabricante.class, idFabricante);
	  em.close();
	return buscado;
	}

	@Override
	public Fabricante findById(int idFabricante) {
		em=EMF.getInstance().createEntityManager();
	 String jpql="select c from Fabricante c "
				+ "left join fetch c.producto "
				+ " where c.idfabricante=:id";  
		TypedQuery<Fabricante> q=em.createQuery(jpql, Fabricante.class);
		q.setParameter("id", idFabricante);
		Fabricante buscado;
		
		try {
			 buscado=q.getSingleResult();
		 } catch(NoResultException e){
			 buscado=null;
			 
		 } finally {
			 em.close();
		 }
		return buscado;
	}

	@Override
	public Set<Fabricante> findOnlyActive() {
		em=EMF.getInstance().createEntityManager();
		String jpql="select c from Fabricante c "
				+ " join c.producto";
		TypedQuery<Fabricante> q= em.createQuery(jpql, Fabricante.class);
		Set<Fabricante> resu=new HashSet<Fabricante>(q.getResultList()); 
		em.close();
		return resu;
		
	}

	@Override
	public Set<Fabricante> findAll() {
		em=EMF.getInstance().createEntityManager();
		String jpql="select c from Fabricante c ";
		TypedQuery<Fabricante>q=em.createQuery(jpql,Fabricante.class);
		Set<Fabricante>resu= new HashSet<Fabricante>(q.getResultList()); 
		em.close();
		return resu;

	}
	
}
