package com.demo.mms.platform.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity{

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "lastModifiedBy")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate",nullable = false, updatable = false)
	@CreatedDate
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModifiedDate",nullable = false)
	@LastModifiedDate
	private Date lastModifiedDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
