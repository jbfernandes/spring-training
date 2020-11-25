package com.accenture.training.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.accenture.training.domain.SalesOrdersEntity;

public class SalesOrderItemsTO implements Serializable {

	
	private String id;

	private String status;

	private Integer quantity;
	

	private String salesOrderId;
	
	private String createdAt;

	private String createdBy;


	private String modifiedAt;
		
	private String modifiedBy;

	public String getCreatedAt() {
		return createdAt;
	}
	
	
	public String getCreatedBy() {
		return createdBy;
	}	

	public String getId() {
		return id;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}


	public String getStatus() {
		return status;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
