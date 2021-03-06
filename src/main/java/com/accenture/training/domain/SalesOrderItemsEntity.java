package com.accenture.training.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.accenture.training.domain.ProductsEntity;

@Entity
@Table(name = "\"TRAINING_SALESORDER_TBLSALESORDERITEM\"")
public class SalesOrderItemsEntity {

	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@Column(name = "\"STATUS\"")
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Column(name = "\"QUANTITY\"")
	private Integer quantity;
		
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	@ManyToOne
    @JoinColumn(name = "\"SALESORDER_ID\"")
	private SalesOrdersEntity salesOrder;	

	public SalesOrdersEntity getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrdersEntity salesOrder) {
		this.salesOrder = salesOrder;
	}


	@ManyToOne
    @JoinColumn(name = "\"PRODUCT_ID\"")
	private ProductsEntity product;	

	public ProductsEntity getUser() {
		return product;
	}

	public void setProduct(ProductsEntity product) {
		this.product = product;
	}
	
	
	@Column(name = "\"CREATEDAT\"")
	private LocalDateTime createdAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	@Column(name = "\"CREATEDBY\"")
	private String createdBy;
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	@Column(name = "\"MODIFIEDAT\"")
	private LocalDateTime modifiedAt;

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
	@Column(name = "\"MODIFIEDBY\"")
	private String modifiedBy;

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


}
