package com.ssm.promotion.core.entity.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * @author liu66
 * 
 */
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
