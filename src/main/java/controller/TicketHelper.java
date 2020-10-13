package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Ticket;

public class TicketHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TicketCounter");

	//insert ticket
	public void insertTicket(Ticket ti) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ti);
		em.getTransaction().commit();
		em.close();
	}

	public List<Ticket> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Ticket> allTickets = em.createQuery("SELECT i FROM Ticket i").getResultList();
		return allTickets;
	}
	
	//to delete ticket
	public void deleteTicket(Ticket toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ticket> typedQuery = em.createQuery(
				"select ti from Ticket ti where ti.description = :selectedDescription and ti.isCompleted = :selectedIsCompleted",
				Ticket.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		typedQuery.setParameter("selectedIsCompleted", toDelete.isCompleted());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Ticket result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	
	//search by ticket id
	public Ticket searchForTicketById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Ticket found = em.find(Ticket.class, idToEdit);
		em.close();
		return found;
	}
	
	//to edit ticket
	public void updateTicket(Ticket toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Ticket> searchForTicketByIsCompleted(Boolean completion) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ticket> typedQuery = em.createQuery("select ti from Ticket ti where ti.isCompleted = :selectedIsCompleted", Ticket.class);
		typedQuery.setParameter("selectedIsCompleted", completion);

		List<Ticket> foundTicket = typedQuery.getResultList();
		em.close();
		return foundTicket;
	}

	public List<Ticket> searchForTicketByDescription(String descriptionName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ticket> typedQuery = em.createQuery("select ti from Ticket ti where ti.description = :selectedDescription", Ticket.class);
		typedQuery.setParameter("selectedDescription", descriptionName);

		List<Ticket> foundTicket = typedQuery.getResultList();
		em.close();
		return foundTicket;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
