package modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="productos")
public class Producto implements Serializable, Comparable <Producto>{
	@Id
	@Column(name="id_producto")
	private int idProducto;
	@ManyToOne
	@JoinColumn(name="fk_fabricante")
	private Fabricante fabricante;
	private double precio;
	private String producto;
	
	
	
	
	
	public int getIdProducto() {
		return idProducto;
	}





	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}





	public Fabricante getFabricante() {
		return fabricante;
	}





	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}





	public double getPrecio() {
		return precio;
	}





	public void setPrecio(double precio) {
		this.precio = precio;
	}





	public String getProducto() {
		return producto;
	}





	public void setProducto(String producto) {
		this.producto = producto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}



	@Override
	public int compareTo(Producto o) {
		
		return  this.idProducto-o.idProducto;
	}
	

	


}
