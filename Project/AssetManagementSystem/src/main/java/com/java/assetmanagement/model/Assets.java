package com.java.assetmanagement.model;

import java.sql.Date;

public class Assets {
	
	private int assetId;
	private String name;
	private String type;
	private int serialNumber;
	private Date purchaseDate;
	private String location;
	private String status;
	private int ownerId;
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public Assets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assets(int assetId, String name, String type, int serialNumber, Date purchaseDate, String location,
			String status, int ownerId) {
		super();
		this.assetId = assetId;
		this.name = name;
		this.type = type;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.location = location;
		this.status = status;
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", name=" + name + ", type=" + type + ", serialNumber=" + serialNumber
				+ ", purchaseDate=" + purchaseDate + ", location=" + location + ", status=" + status + ", ownerId="
				+ ownerId + "]";
	}

	
	
}
