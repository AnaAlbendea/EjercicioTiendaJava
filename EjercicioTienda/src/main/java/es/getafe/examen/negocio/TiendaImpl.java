package es.getafe.examen.negocio;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import es.getafe.examen.persistencia.FabricanteDao;
import es.getafe.examen.persistencia.FabricanteDaoImpl;
import es.getafe.examen.persistencia.ProductoDao;
import es.getafe.examen.persistencia.ProductoDaoImpl;
import modelo.Fabricante;
import modelo.Producto;

public class TiendaImpl implements Tienda{
	 private FabricanteDao fDao;
	 private ProductoDao  pDao;
	  
	public TiendaImpl() {
		fDao= new FabricanteDaoImpl();	
		pDao= new ProductoDaoImpl() ;
	
	}

	@Override
	public Set<Producto> getProductos() {
		Set<Producto> pro= new TreeSet<Producto>(getProductoCom());
 		pro.addAll(pDao.findAll());	
 		return pro;
	}
	
	 private Comparator<Producto> getProductoCom() {
		 
		return  new Comparator<Producto>() {

			@Override
			public int compare(Producto p1, Producto p2) {
				Collator col= Collator.getInstance(new Locale("es"));
		
				return col.compare(p1.getProducto()+p1.getIdProducto(),p2.getProducto()+p2.getIdProducto());
		}
		};
	 }

	@Override
	public Set<Producto> getProductos(String descripcion) {
		Set<Producto> resu= new TreeSet<>(pDao.findByDescripcion(descripcion));
		if(resu.size() == 0)
			return null;
		return resu;
	}

	@Override
	public double getMediaPrecioProductosByFabricante(int idFabricante) {
		Fabricante buscado = fDao.findById(idFabricante);
		if(buscado != null) {
			double suma = 0;
			for (Producto producto : buscado.getProducto()) {
				suma += producto.getPrecio();
			}
			return suma / buscado.getProducto().size();
		}
		return 0;
	}
	

	@Override
	public void addFabricante(Fabricante fabricante) {
		fDao.save(fabricante);
		
	}

	@Override
	public void addProducto(Producto producto) {
		pDao.save(producto);
	}

	private Comparator<Fabricante>getCompFab(){
		return new Comparator<Fabricante>() {

			@Override
			public int compare(Fabricante F1, Fabricante F2) {
				Collator col= Collator.getInstance(new Locale("es"));
			return col.compare(F1.getFabricante() + F1.getIdfabricante(), F2.getFabricante() + F2.getIdfabricante());
				
			}
			
		};
		
	}
	
	@Override
	public Set<Fabricante> getFabricantes() {
		Set<Fabricante> fabricante = new TreeSet<>(getCompFab());
		fabricante.addAll(fDao.findAll());
		return fabricante;
	}
	

	@Override
	public Set<Fabricante> getFabricantesActivos() {
		Set<Fabricante> fabricante = new TreeSet<>(getCompFab());
		fabricante.addAll(fDao.findOnlyActive());
		return fabricante;
	}

	@Override
	public Fabricante getFabricante(int idFabricante) {
		return fDao.findByIdLazy(idFabricante);
	}

	@Override
	public Fabricante getFabricanteConProductos(int idFabricante) {
		return fDao.findById(idFabricante);
	} 

}
