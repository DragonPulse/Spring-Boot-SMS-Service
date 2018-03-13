package com.demo.mms.platform.entity;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
/**
 * 
 * @author Vijay Kumar
 *
 */

@Entity
@Table(name="MASTER_MESSAGE_CONFIG",schema="WEBSITE_MMS")
public class MasterMessageConfig extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7952729804726944306L;

	@Id @Column(name = "MMC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long mmcId;
	
	@Column(name = "OWNER_ID")
	private String ownerId;
	
	@Column(name = "MSG_TYPE")
	private String msgType;
	
	@Column(name = "MSG_BODY")
	private String msgBody;




	public MasterMessageConfig() {
	}

	public MasterMessageConfig(String ownerId, String msgType, String msgBody) {
		this.ownerId = ownerId;
		this.msgType = msgType;
		this.msgBody = msgBody;
	}

	public Long getMmcId() {
		return mmcId;
	}

	public void setMmcId(Long mmcId) {
		this.mmcId = mmcId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	
	@Override
	public String toString() {
		return "MasterMessageConfig [id=" + mmcId + ", ownerId=" + ownerId + ", msgType=" + msgType + ", msgBody="
				+ msgBody + "]";
	}



}
