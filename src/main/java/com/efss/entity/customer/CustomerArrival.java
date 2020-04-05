package com.efss.entity.customer;
/**
 *到店记录 
 * */
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerArrival implements Serializable{
  
	private static final long serialVersionUID = 1L;

	private String id;

    private String customerId;
    
    private String arrivalTime;//到店时间

    private String arrivalLength;//到店时长

    private String arrivalRecord;//到店记录

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

	public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime == null ? null : arrivalTime.trim();
    }

    public String getArrivalLength() {
        return arrivalLength;
    }

    public void setArrivalLength(String arrivalLength) {
        this.arrivalLength = arrivalLength == null ? null : arrivalLength.trim();
    }

    public String getArrivalRecord() {
        return arrivalRecord;
    }

    public void setArrivalRecord(String arrivalRecord) {
        this.arrivalRecord = arrivalRecord == null ? null : arrivalRecord.trim();
    }
}