package com.demo.mms.platform.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="message_details",schema="WEBSITE_MMS")
public class MessageDetails extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "message_details_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name = "sent_message")
    private String sentMessage;


    @Column(name = "sent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name="mmc_id",foreignKey=@ForeignKey(name="fk_message_details_mmc_id"))
    private MasterMessageConfig masterMessageConfig;

    @ManyToOne
    @JoinColumn(name="subscriber_id",foreignKey=@ForeignKey(name="fk_message_details_subscriber_id"))
    private MessageSubscription subscriber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(String sentMessage) {
        this.sentMessage = sentMessage;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MasterMessageConfig getMasterMessageConfig() {
        return masterMessageConfig;
    }

    public void setMasterMessageConfig(MasterMessageConfig masterMessageConfig) {
        this.masterMessageConfig = masterMessageConfig;
    }

    public MessageSubscription getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(MessageSubscription subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return "MessageDetails{" +
                "messageDetailsId=" + id +
                ", sentMessage='" + sentMessage + '\'' +
                ", sentDate='" + sentDate + '\'' +
                ", status='" + status + '\'' +
                ", masterMessageConfig=" + masterMessageConfig +
                ", subscriber=" + subscriber +
                '}';
    }
}
