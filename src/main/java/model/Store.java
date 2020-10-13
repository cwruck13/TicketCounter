package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store")

public class Store {
	
	//attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STORE_ID")
	private int storeId;
	@Column(name="STORE_NAME")
	private String storeName;
	@Column(name="STORE_ADDRESS")
	private String storeAddress;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	//default no args
	public Store() {
		super();
	}

	//one arg
	public Store(String storeName) {
		super();
		this.storeName = storeName;
	}

	//two args
	public Store(int storeId, String storeName) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
	}

	//all args
	public Store(int storeId, String storeName, String storeAddress, String phoneNumber) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.phoneNumber = phoneNumber;
	}


	//getters and setters
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
