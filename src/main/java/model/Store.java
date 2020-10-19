package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {
	
	@Id
	@Column(name = "STORE_CODE")
	private String storeCode;
	
	@Column(name = "STORE_NAME")
	private String storeName;
	
	@Column(name = "STORE_ADDRESS")
	private String storeAddress;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	//default no args
	public Store() {
		super();
	}

	public Store(String storeCode, String storeName, String storeAddress, String phoneNumber) {
		super();
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.phoneNumber = phoneNumber;
	}



	public Store(String storeCode) {
		super();
		this.storeCode = storeCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
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
		return "Store [storeCode=" + storeCode + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", phoneNumber=" + phoneNumber + "]";
	}



}
