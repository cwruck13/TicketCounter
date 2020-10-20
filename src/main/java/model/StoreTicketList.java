package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="store_tickets")
public class StoreTicketList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STORE_LIST_ID")
	private int storeTicketsID;
	
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="STORE_CODE")
	private Store store;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Ticket> listOfTickets;
	
	
	public StoreTicketList() {
		super();
	}
	
	public StoreTicketList(Store store, List<Ticket> listOfTickets) {
		super();
		this.store = store;
		this.listOfTickets = listOfTickets;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Ticket> getListOfTickets() {
		return listOfTickets;
	}

	public void setListOfTickets(List<Ticket> listOfTickets) {
		this.listOfTickets = listOfTickets;
	}
	
	

}
