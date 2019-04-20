package com.ssm.promotion.core.entity;

import com.ssm.promotion.core.entity.base.BaseEntity;

/**
 * @author liu66
 * 
 */
public class Course extends BaseEntity{
	
	private String courseName;
	private String description;
	private Integer categoryId;
	private String tag;
	private Integer isDel;
	private Integer isNotPaper;
	private String courseImg;
	private Double price;
	
	
	
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
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", description=" + description + ", categoryId=" + categoryId
				+ ", tag=" + tag + ", isDel=" + isDel + ", isNotPaper=" + isNotPaper + ", courseImg=" + courseImg
				+ ", price=" + price + "]";
	}
	
}
