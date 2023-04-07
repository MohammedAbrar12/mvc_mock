package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Empdto;

public class empdao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public void insert(Empdto dto) {
		// TODO Auto-generated method stub
		et.begin();
		em.persist(dto);
		et.commit();
		
	}
	public Empdto findbyId(String empid) {
		// TODO Auto-generated method stub
		Empdto e1=em.find(Empdto.class, empid );
		return e1;
	}
	public void deletedata(Empdto empdto1) {
		// TODO Auto-generated method stub
		et.begin();
		em.remove(empdto1);
		et.commit();
		
	}
	public Empdto fetch(String empid) {
		// TODO Auto-generated method stub
		Empdto e2=em.find(Empdto.class, empid);
		return e2;
	}
	

}
