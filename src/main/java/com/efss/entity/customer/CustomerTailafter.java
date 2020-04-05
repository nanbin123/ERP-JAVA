package com.efss.entity.customer;
/**
 * 追踪记录
 */
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerTailafter implements Serializable{
  
	private static final long serialVersionUID = 9101737047211760344L;

	private String id;
    
    private String customerId;

    private String tailafterTime;//追踪时间

    private String tailafterLength;//追踪时长

    private String tailafterRecord;//追踪记录
    
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
	public String getTailafterTime() {
        return tailafterTime;
    }

    public void setTailafterTime(String tailafterTime) {
        this.tailafterTime = tailafterTime == null ? null : tailafterTime.trim();
    }

    public String getTailafterLength() {
        return tailafterLength;
    }

    public void setTailafterLength(String tailafterLength) {
        this.tailafterLength = tailafterLength == null ? null : tailafterLength.trim();
    }

    public String getTailafterRecord() {
        return tailafterRecord;
    }

    public void setTailafterRecord(String tailafterRecord) {
        this.tailafterRecord = tailafterRecord == null ? null : tailafterRecord.trim();
    }
}