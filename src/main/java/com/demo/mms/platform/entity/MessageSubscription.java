package com.demo.mms.platform.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="MESSAGE_SUBSCRIPTION",schema="WEBSITE_MMS")
public class MessageSubscription extends AbstractEntity{
	
	@Id @Column(name = "subscription_id")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;


	@ManyToOne
	@JoinColumn(name="MMC_ID",foreignKey=@ForeignKey(name="MMC_ID_FK"))
	private MasterMessageConfig masterMessageConfig;
	

	
	@Column(name = "to_number")
	private String toNumber;
	

	@Column(name = "delete")
	private Boolean delete;

	@Column(name = "opt_out")
	private Boolean optOut;


	public Boolean getOptOut() {
		return optOut;
	}

	public void setOptOut(Boolean optOut) {
		this.optOut = optOut;
	}

	public MasterMessageConfig getMasterMessageConfig() {
		return masterMessageConfig;
	}


	public void setMasterMessageConfig(MasterMessageConfig masterMessageConfig) {
		this.masterMessageConfig = masterMessageConfig;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	

	public String getToNumber() {
		return toNumber;
	}


	public void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}


	public Boolean getDelete() {
		return delete;
	}


	public void setDelete(Boolean delete) {
		this.delete = delete;
	}




	@Override
	public String toString() {
		return "MessageSubscription [id=" + id + ", masterMessageCofig=" + masterMessageConfig + ", toNumber=" + toNumber
				+ ", delete=" + delete + "]";
	}
	
	
	
	
}
