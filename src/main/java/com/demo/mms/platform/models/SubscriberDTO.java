package com.demo.mms.platform.models;

public class SubscriberDTO {

    private Long id;

    private String toNumber;


    private MasterMessageConfigDTO masterMessageConfigDTO;


    private String messageType;

    private String ownerId;

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }



    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MasterMessageConfigDTO getMasterMessageConfigDTO() {
        return masterMessageConfigDTO;
    }

    public void setMasterMessageConfigDTO(MasterMessageConfigDTO masterMessageConfigDTO) {
        this.masterMessageConfigDTO = masterMessageConfigDTO;
    }

    @Override
    public String toString() {
        return "SubscriberDTO{" +
                "id=" + id +
                ", toNumber='" + toNumber + '\'' +
                ", masterMessageConfigDTO=" + masterMessageConfigDTO +
                ", messageType='" + messageType + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
