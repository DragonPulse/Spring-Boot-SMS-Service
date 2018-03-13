package com.demo.mms.platform.models;


import java.io.Serializable;
/**
 * 
 * @author Vijay Kumar
 *
 */


public class MasterMessageConfigDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6617258891289615698L;
	
	private Long id;

	private String ownerId;
	
	private String msgType;
	
	private String msgBody;
	
	private String createdBy;
	
	private String updatedBy;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MasterMessageConfigDTO [ownerId=" + ownerId + ", msgType=" + msgType + ", msgBody=" + msgBody
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

	
}
