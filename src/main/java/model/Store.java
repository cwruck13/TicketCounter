package model;

public class Store {
	
	//variables
	private int storeId;
	private String storeName;
	private String storeAddress;
	private String phoneNumber;
	
	//default no args
	public Store() {
		super();
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

	

}
