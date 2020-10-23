package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Store;
import model.Ticket;

public class StoreHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TicketCounter");
	
	public void insertStore(Store st) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(st);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Store> showAllStores(){
		EntityManager em = emfactory.createEntityManager();
		List<Store> allStores = em.createQuery("SELECT s FROM Store s").getResultList();
		return allStores;
	}
	
	public Store findStore(String storeCode){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Store> typedQuery = em.createQuery("select st from Store st where st.storeCode = :selectedCode", Store.class);
		typedQuery.setParameter("selectedCode", storeCode);
		Store foundStore;
		try {
			foundStore = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundStore = new Store(storeCode);
		}
		em.close();
		return foundStore;
	}
	
	
	public void updateStore(Store toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
