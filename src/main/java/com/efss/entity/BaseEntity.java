package com.efss.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseEntity<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 实体编号（唯一标识）
	 */
	protected String id;

	/**
	 * userid（唯一标识）
	 */
	protected String userid;

	/**
	 * 创建日期
	 * @return
	 */

	protected Date createDate;

	/**
	 * 修改日期
	 * @return
	 */

	protected Date updateDate;
	/**
	 * 创建人
	 */
	protected String userName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 删除标志  1  删除   0  正常
	 */
	private String delflag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelflag() {
		if("".equals(delflag)||delflag==null){
			return "0";
		}
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
}
