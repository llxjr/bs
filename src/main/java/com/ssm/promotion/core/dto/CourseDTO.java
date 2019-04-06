package com.ssm.promotion.core.dto;

import java.io.Serializable;
import java.util.Date;

import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.base.BaseEntity;

/**
 * @author liu66
 * @oper_time 2018年10月22日
 */
public class CourseDTO implements Serializable{
	private int id;
	private String courseName;
	private String description;
	private String categoryId;
	private Category category;
	private String tag;
	private Integer isDel;
	private Integer isNotPaper;
	private String courseImg;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public Integer getIsNotPaper() {
		return isNotPaper;
	}
	public void setIsNotPaper(Integer isNotPaper) {
		this.isNotPaper = isNotPaper;
	}
	public String getCourseImg() {
		return courseImg;
	}
	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}
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
	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", courseName=" + courseName + ", description=" + description + ", category="
				+ category + ", tag=" + tag + ", isDel=" + isDel + ", isNotPaper=" + isNotPaper + ", courseImg="
				+ courseImg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + "]";
	}
	
}
