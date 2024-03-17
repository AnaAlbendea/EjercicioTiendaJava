package es.getafe.examen.negocio;

import java.util.Set;

import modelo.Fabricante;
import modelo.Producto;

public interface Tienda {
	
	/**
	 * Retorna todos los productos almacenados, ordenados por su descripcion
	 * @return Set de productos.
	 */
	public Set<Producto> getProductos();
	
	/**
	 * Retorna todos los productos almacenados que contienen una descripcion, 
	 * ordenados por su orden natural
	 * @param descripcion que debe contener la descripcion de los productos
	 * @return Set de productos encontrados. null si no hay ninguno.
	 */
	public Set<Producto> getProductos(String descripcion);
	
	/**
	 * Retorna la media de los precios de los productos de un Fabricante.
	 * @param idFabricante
	 * @return media de precios o 0 si el fabricante no existe o no tiene productos.
	 */
	public double getMediaPrecioProductosByFabricante(int idFabricante);
	
	/**
	 * Indica que se debe agregar el nuevo fabricante a la BBDD
	 * @param fabricante
	 */
	public void addFabricante(Fabricante fabricante);
	
	/**
	 * Indica que se debe agregar el nuevo producto a la BBDD
	 * @param producto
	 */
	public void addProducto(Producto producto);
	
	/**
	 * Retorna todos los fabricantes almacenados, ordenados por su descripcion
	 * @return Set de fabricantes.
	 */
	public Set<Fabricante> getFabricantes();

	/**
	 * Retorna todos los fabricantes que suministran algun producto, 
	 * ordenados por su descripcion
	 * @return Set de fabricantes.
	 */
	public Set<Fabricante> getFabricantesActivos();
	
	/**
	 * Retorna un fabricante por Id
	 * @return Fabricante buscado.
	 */
	public Fabricante getFabricante(int idFabricante);
	
	/**
	 * Retorna un fabricante por Id con sus productos asociados
	 * @return Fabricante buscado.
	 */
	public Fabricante getFabricanteConProductos(int idFabricante);
	
}
