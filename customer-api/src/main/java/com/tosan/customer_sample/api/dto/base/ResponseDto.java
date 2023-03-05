package com.tosan.customer_sample.api.dto.base;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="ResponseDto")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="responseDto", namespace ="http://www.tosan.com/responseDto")
public class ResponseDto<T> {
    @XmlElement
    private String message;
    @XmlElement
    private String status;
    @XmlElement
    private T result;

    public ResponseDto() {
    }

    public ResponseDto(String message, String status, T result) {
        this.message = message;
        this.status = status;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    /* builder */
    public ResponseDto message(String message) {
        this.message = message;
        return this;
    }

    public ResponseDto status(String status) {
        this.status = status;
        return this;
    }

    public ResponseDto result(T result) {
        this.result = result;
        return this;
    }

    public ResponseDto build() {
        return new ResponseDto(this.getMessage(), this.getStatus(), this.getResult());
    }

}
