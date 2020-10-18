package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "STORE")
	private String store;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "IS_COMPLETE")
	private boolean isCompleted;
	
	
	//default no args
	public Ticket() {
		super();
	}

	//two args
	public Ticket(int id, boolean isCompleted) {
		super();
		this.isCompleted = isCompleted;
		this.id = id;
	}

	//three args
	public Ticket(int id, String store, boolean isCompleted) {
		super();
		this.isCompleted = isCompleted;
		this.store = store;
		this.id = id;
	}

	/**
	 * Default constructor when creating tickets for the store.
	 * @param store
	 * @param isCompleted
	 * @param description
	 */
	public Ticket(String store, boolean isCompleted,  String description) {
		super();
		this.description = description;
		this.isCompleted = isCompleted;
		this.store = store;
	}


	//getters and setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStore() {
		return store;
	}


	public void setStoreId(String store) {
		this.store = store;
	}


	public boolean isCompleted() {
		return isCompleted;
	}


	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", description=" + description + ", storeId=" + store + ", isCompleted="
				+ isCompleted + "]";
	}
	
}
