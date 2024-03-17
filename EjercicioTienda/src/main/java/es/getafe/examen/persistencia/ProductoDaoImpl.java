package es.getafe.examen.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Fabricante;
import modelo.Producto;



public class ProductoDaoImpl implements ProductoDao{
	private EntityManager em;

	@Override
	public Producto findById(int idProducto) {
		em=EMF.getInstance().createEntityManager();
		String jpql="select c from Producto c "
				+ " where c.idProducto=:id"; 
		TypedQuery<Producto>q=em.createQuery(jpql,Producto.class); 
		 q.setParameter("id", idProducto); 
		Producto buscado;
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
	public List<Producto> findByDescripcion(String descripcion) {
		em=EMF.getInstance().createEntityManager();
		String jpql= "Select p from Producto p"
				+ " where p.producto like :pro"; 
		TypedQuery<Producto>p= em.createQuery(jpql,Producto.class);
		p.setParameter("pro", "%" + descripcion + "%");
		List<Producto>resu= new ArrayList<Producto>(p.getResultList()); 
		em.close();
		return  resu;
	}

	@Override
	public List<Producto> findAll() {
		em=EMF.getInstance().createEntityManager();
		String spql= "select p from Producto p";
		TypedQuery<Producto> p=em.createQuery(spql, Producto.class);
		List<Producto>resu= new ArrayList<Producto>(p.getResultList()); 
		em.close();
		return resu;
	}

	@Override
	public void save(Producto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		
	}
}

	