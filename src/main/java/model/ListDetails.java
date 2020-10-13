package model;

import java.time.LocalDate;
import java.util.List;

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

@Entity
@Table(name="list_details")
public class ListDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="TICKET_DATE")
	private LocalDate ticketDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Store store;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="TICKETS_ON_LIST",
	      joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	      inverseJoinColumns={ @JoinColumn(name="TICKET_ID", referencedColumnName="ID", unique=true) }
	  )
	
	//default no arg
	private List<Ticket> listOfTickets;
	public ListDetails() {
		super();
	}
	
	//all args
	public ListDetails(int id, String listName, LocalDate ticketDate, Store store, List<Ticket> listOfTickets) {
		super();
		this.id = id;
		this.listName = listName;
		this.ticketDate = ticketDate;
		this.store = store;
		this.listOfTickets = listOfTickets;
	}

	//no id
	public ListDetails(String listName, LocalDate ticketDate, Store store, List<Ticket> listOfTickets) {
		super();
		this.listName = listName;
		this.ticketDate = ticketDate;
		this.store = store;
		this.listOfTickets = listOfTickets;
	}

	//no id and no list
	public ListDetails(String listName, LocalDate ticketDate, Store store) {
		super();
		this.listName = listName;
		this.ticketDate = ticketDate;
		this.store = store;
	}

	//getters and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
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

	//to string 
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", ticketDate=" + ticketDate + ", store=" + store
				+ ", listOfTickets=" + listOfTickets + "]";
	}


}
