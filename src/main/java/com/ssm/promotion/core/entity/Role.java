package com.ssm.promotion.core.entity;

import com.ssm.promotion.core.entity.base.BaseEntity;


public class Role extends BaseEntity {
	
	/** 等级 */
	private Integer grade;
	/** 角色名称 */
	private String roleName;
	/** 描述 */
	private String description;
	/** 是否启用 */
	private Integer isUsed;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
