package com.demo.mms.platform.models;

public class MessageDetailsDTO {

    private String messageDetailsId;

    private String sentMessage;

    private String toNumber;

    private String fromNumber;

    private String status;

    private Long masterMessageConfigId;

    private Long subscriberId;

    public Long getMasterMessageConfigId() {
        return masterMessageConfigId;
    }

    public void setMasterMessageConfigId(Long masterMessageConfigId) {
        this.masterMessageConfigId = masterMessageConfigId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getMessageDetailsId() {
        return messageDetailsId;
    }

    public void setMessageDetailsId(String messageDetailsId) {
        this.messageDetailsId = messageDetailsId;
    }

    public String getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(String sentMessage) {
        this.sentMessage = sentMessage;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
