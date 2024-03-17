import javax.persistence.EntityManager;

import es.getafe.examen.persistencia.EMF;
import modelo.Fabricante;



public class Test {

	public static void main(String[] args) {
		EntityManager em=EMF.getInstance().createEntityManager();
		
//		Especialidades e=new Especialidades();
//		//e.setEspecialidad("Hematología"); esto es para ver si funciona inserccion
//		
//		EspecialidadesImp ei=new EspecialidadesImp();
//		//ei.insertar(e);
//		e.setEspecialidad("Hematología");
		 
	
		Fabricante f=em.find(Fabricante.class,2); //para buscar y actualizar
		if(f!=null) {
			System.out.println();
		}
		
//		f.getFabricante();
//		
//		em.getTransaction().begin();
//		em.merge(f);
//		em.getTransaction().commit();
//		em.close();
	}



}


