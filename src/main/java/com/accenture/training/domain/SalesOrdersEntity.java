package com.accenture.training.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "\"TRAINING_SALESORDER_TBLSALESORDER\"")
public class SalesOrdersEntity {

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
	
	
	@OneToMany(mappedBy = "salesOrder", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH })
	private List<SalesOrderItemsEntity> items;
	
	public List<SalesOrderItemsEntity> getItems() {
		return items;
	}

	public void setItems(List<SalesOrderItemsEntity> items) {
		this.items = items;
	}


	@ManyToOne
    @JoinColumn(name = "\"USER_ID\"")
	private UsersEntity user;	

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}
	

	@ManyToOne
    @JoinColumn(name = "\"CLIENT_ID\"")
	private ClientsEntity client;	

	public ClientsEntity getClient() {
		return client;
	}

	public void setClient(ClientsEntity client) {
		this.client = client;
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
