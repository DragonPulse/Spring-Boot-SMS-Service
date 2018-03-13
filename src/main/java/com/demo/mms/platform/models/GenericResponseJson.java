package com.demo.mms.platform.models;

import org.springframework.http.HttpStatus;

/**
 * The type Generic response json.
 */
public class GenericResponseJson {

    private String responseType;

    private HttpStatus responseStatus;

    private String responseMessage;

    /**
     * Instantiates a new Generic response json.
     *
     * @param responseType    the response type
     * @param responseStatus  the response status
     * @param responseMessage the response message
     */
    public GenericResponseJson(String responseType, HttpStatus responseStatus, String responseMessage) {
        this.responseType = responseType;
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
    }

    /**
     * Gets response type.
     *
     * @return the response type
     */
    public String getResponseType() {
        return responseType;
    }

    /**
     * Sets response type.
     *
     * @param responseType the response type
     */
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    /**
     * Gets response status.
     *
     * @return the response status
     */
    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets response status.
     *
     * @param responseStatus the response status
     */
    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * Gets response message.
     *
     * @return the response message
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets response message.
     *
     * @param responseMessage the response message
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
