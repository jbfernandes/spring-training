package com.accenture.training.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import com.accenture.training.domain.SalesOrderItemsEntity;

public class SalesOrdersTO implements Serializable {

	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	private Integer quantity;
		
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	private List<SalesOrderItemsTO> items;

	public List<SalesOrderItemsTO> getItems() {
		return items;
	}

	public void setItems(List<SalesOrderItemsTO> items) {
		this.items = items;
	}


	private UsersTO user;

	public UsersTO getUser() {
		return user;
	}

	public void setUser(UsersTO user) {
		this.user = user;
	}


	private ClientsTO client;
	
	public ClientsTO getClient() {
		return client;
	}

	public void setClient(ClientsTO client) {
		this.client = client;
	}

	
	
	private String createdAt;

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	private String createdBy;
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	private String modifiedAt;

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
	private String modifiedBy;

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
