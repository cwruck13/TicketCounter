package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name="STORE_CODE")
	private String storeCode;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "IS_COMPLETE")
	private boolean isCompleted;
	
	@Column(name="TICKET_DATE")
	private LocalDate ticketDate;
	
	//default new ticket
	public Ticket() {
		super();
		this.storeCode = "1889";
		this.description = "PLEASE FILL IN DESCRIPTION";
		this.isCompleted = false;
	}
	

	public Ticket(String storeCode, String description, boolean isCompleted, LocalDate ticketDate) {
		super();
		this.storeCode = storeCode;
		this.description = description;
		this.isCompleted = isCompleted;
		this.ticketDate = ticketDate;
	}


	public Ticket(String storeCode, String description, boolean isCompleted) {
		super();
		this.storeCode = storeCode;
		this.description = description;
		this.isCompleted = isCompleted;
		this.ticketDate = LocalDate.now();
	}
	

	public Ticket(int id, String storeCode, String description, boolean isCompleted) {
		super();
		this.id = id;
		this.storeCode = storeCode;
		this.description = description;
		this.isCompleted = isCompleted;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStoreCode() {
		return storeCode;
	}


	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean getIsCompleted() {
		return isCompleted;
	}


	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public LocalDate getTicketDate() {
		return ticketDate;
	}


	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
	}


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", storeCode=" + storeCode + ", description=" + description + ", isCompleted="
				+ isCompleted + ", ticketDate=" + ticketDate + "]";
	}



	
	
	
}
