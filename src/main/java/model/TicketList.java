package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticketlist")
public class TicketList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="LIST_ID")
	private ListDetails details;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Ticket description;

	public TicketList() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListDetails getDetails() {
		return details;
	}

	public void setDetails(ListDetails details) {
		this.details = details;
	}

	public Ticket getDescription() {
		return description;
	}

	public void setDescription(Ticket description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TicketList [id=" + id + ", details=" + details + ", description=" + description + "]";
	}

}
