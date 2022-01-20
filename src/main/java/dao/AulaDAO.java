package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Aula;
import model.Usuario;
import utils.HibernateUtil;

public class AulaDAO {
	
	public List<Aula> seleccionarAulas(){
		
		List<Aula> aulas = new ArrayList<Aula>();
		SessionFactory sessfact = HibernateUtil.getSessionFactory();
		
		Session session = sessfact.getCurrentSession();
		
		Transaction tr = null;
		
		try {
			
			tr = session.beginTransaction();
			aulas = session.createQuery("Select a from Aula a", Aula.class).getResultList();
			
		}catch(Exception ex){
			
			if(tr!=null) 
				tr.rollback();
			
			ex.printStackTrace();
			aulas = null; 
			
		}
		finally {
			session.close();
			sessfact.close();
		}
		
		return aulas; 
		
	}
	
	
	public Aula obtenerAula(int numAula) {
		Aula aula = new Aula();
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		Session session = sessFact.getCurrentSession();
		
		Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			aula = session.get(Aula.class, numAula);
			
		}
		catch (Exception ex) {
			
			if(tr!= null) 
				tr.rollback();
			
			ex.printStackTrace();
			aula = null;  
		}
		finally {
			session.close();
			sessFact.close();
		}
		
		return aula;
		
	}
	
	public boolean crear (int numAula, int capacidad, String descripcion, String nombre) {
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();		
		Session session = sessFact.getCurrentSession();		
		Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			Aula aula = new Aula();
			aula.setNumaula(numAula);
			aula.setCapacidad(capacidad);
			aula.setDescripcion(descripcion);
			aula.setNombre(nombre);
			
			session.save(aula);
			tr.commit();
			return true; 			
			
		} catch (Exception ex) {
			
			if(tr!= null) 
				tr.rollback();
			
			ex.printStackTrace();
			return false;   
		}
		finally {
			session.close();
			sessFact.close();
		}		
		
	}
	
	public boolean actualizar(int numAula, int capacidad, String descripcion, String nombre) {
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();		
		Session session = sessFact.getCurrentSession();		
		Transaction tr = null;
		
		try {
			tr = session.beginTransaction();
			Aula aula = session.get(Aula.class, numAula);
			aula.setCapacidad(capacidad);
			aula.setDescripcion(descripcion);
			aula.setNombre(nombre);
			
			session.update(aula);
			tr.commit();
			return true; 
			
		}catch (Exception ex) {
			
			if(tr!= null) 
				tr.rollback();
			
			ex.printStackTrace();
			return false;   
		}
		finally {
			session.close();
			sessFact.close();
		}	
		
	}
	
	public boolean eliminar (int numAula) {
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();		
		Session session = sessFact.getCurrentSession();		
		Transaction tr = null;
		
		try {
			
			tr = session.beginTransaction();
			Aula aula = session.get(Aula.class, numAula);
			
			session.delete(aula);
			tr.commit();
			return true;
			
			
		}catch (Exception ex) {
			
			if(tr!= null) 
				tr.rollback();
			
			ex.printStackTrace();
			return false;   
		}
		finally {
			session.close();
			sessFact.close();
		}	
		
	}
	
	public List<Aula> getAulas(){

		List<Aula> aulas = new ArrayList<Aula>();
		
		SessionFactory sessfact = HibernateUtil.getSessionFactory();		
		Session session = sessfact.getCurrentSession();		
		Transaction tr = null;
		
		try {			
			tr = session.beginTransaction();
			String sql = "Select a from Aula a";
			Query<Aula> query = (Query<Aula>)session.createQuery(sql);
			aulas = query.list();
			
		}catch(Exception ex){
			
			if(tr!=null) 
				tr.rollback();
			
			ex.printStackTrace();
			 
			
		}
		finally {
			session.close();
			sessfact.close();
		}
		return aulas;
	} 
}
