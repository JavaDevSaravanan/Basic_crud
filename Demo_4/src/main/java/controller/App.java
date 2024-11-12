package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import entities.Student;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import util.HibernateUtil;


public class App {
	public static void main(String[] args) {

	    Transaction transaction = null;

	    
//	    try {
//	    	Session session = HibernateUtil.getSessionFactory().openSession();
//	    	transaction = session.beginTransaction();
//	        Student student = new Student(3,"Muthu","Civil","S");
//			// save the student objects
//	        session.persist(student);
//	        // commit transaction
//	        transaction.commit();
//	    } catch (Exception e) {
//	        if (transaction != null) {
//	            transaction.rollback();
//	        }
//	        e.printStackTrace();
//	    }
//	    
//	    try {
//	    	Session session = HibernateUtil.getSessionFactory().openSession();
//	    	transaction = session.beginTransaction();
//	    	Student stud=session.get(Student.class, 2);
//	    	System.out.println(stud);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	    try {
//	    	Session session = HibernateUtil.getSessionFactory().openSession();
//	    	transaction = session.beginTransaction();
//	    	    	Student student2 = new Student();
//	    	    	student2.setId(2);
//	    	    	session.delete(student2);
//	    	    	
//	    	    	transaction.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	    
//	    try {
//	    	Session session = HibernateUtil.getSessionFactory().openSession();
//	    	transaction = session.beginTransaction();
//	    	
//	   
//	    	session.createNativeQuery("UPDATE Student SET name = :name WHERE id = :id") .setParameter("name", "Raju") .setParameter("id", 1) .executeUpdate();
//	    	
//	    	Student student = session.get(Student.class, 3);
//	    	student.setDept("civil");
//	    	transaction.commit();
//	    	session.close();
//	    	
//	    	
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	    
	    
	    
//	    try {
//	    	Session session = HibernateUtil.getSessionFactory().openSession();
//	    	transaction = session.beginTransaction();
//	   Query query =	session.createQuery("From Student");
//	   
//	    
//	  java.util.List list = query.list();
//	  System.out.println(list);
//	    	
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	    
	    try {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
	    	
	    	CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
	    	Root<Student> root = criteriaQuery.from(Student.class);
	    	
	    	criteriaQuery.select(root).where(builder.equal(root.get("id"), 1));
	    	java.util.List<Student> students = session.createQuery(criteriaQuery).getResultList();
	    	students.forEach(System.out::println); 
	    	session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
