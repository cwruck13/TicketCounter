package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Store;

public class StoreHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TicketCounter");

	//insert ticket
	public void insertStore(Store ti) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ti);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Store> showAllStore() {
		EntityManager em = emfactory.createEntityManager();
		List<Store> allStores = em.createQuery("SELECT s FROM STORE s").getResultList();
		return allStores;
	}
	
	public Store findStore(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Store> typedQuery = em.createQuery("select st from Store st where st.storeName = :selectedName",
				Store.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Store foundStore;
		try {
			foundStore = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundStore = new Store(nameToLookUp);
		}
		em.close();

		return foundStore;
	}
}
