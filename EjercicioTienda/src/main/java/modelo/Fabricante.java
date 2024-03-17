package modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fabricantes")
public class Fabricante implements Serializable, Comparable<Fabricante>  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fabricante")	
	private int idfabricante;
	@OneToMany(mappedBy = "fabricante")
	private Set<Producto>producto;
	private String fabricante;
	


	
	public int getIdfabricante() {
		return idfabricante;
	}



	public void setIdfabricante(int idfabricante) {
		this.idfabricante = idfabricante;
	}




	public Set<Producto> getProducto() {
		return producto;
	}



	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}




	public String getFabricante() {
		return fabricante;
	}



	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idfabricante);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		return idfabricante == other.idfabricante;
	}



	@Override
	public String toString() {
		return "Fabricante [idfabricante=" + idfabricante + ", producto=" + producto + ", fabricante=" + fabricante
				+ "]";
	}



	public int compareTo(Fabricante o) {
	
	return this.idfabricante - o.idfabricante;
	}



}
