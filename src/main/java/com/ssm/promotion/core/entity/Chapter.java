package com.ssm.promotion.core.entity;

import com.ssm.promotion.core.entity.base.BaseEntity;
/**
 * 
 * @author llz
 *
 */
public class Chapter extends BaseEntity {
	private int id;
	private int categoryId;
	private int courseId;
	private String courseName;
	private String  tag;
	private String chapterName;
	private int hasVideo;
	private int hasChild;
	private int parentId;
	private int isFree;
	private int tOrder;
	private int functionType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public int getHasVideo() {
		return hasVideo;
	}
	public void setHasVideo(int hasVideo) {
		this.hasVideo = hasVideo;
	}
	public int getHasChild() {
		return hasChild;
	}
	public void setHasChild(int hasChild) {
		this.hasChild = hasChild;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getIsFree() {
		return isFree;
	}
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	
	public int gettOrder() {
		return tOrder;
	}
	public void settOrder(int tOrder) {
		this.tOrder = tOrder;
	}
	public int getFunctionType() {
		return functionType;
	}
	public void setFunctionType(int functionType) {
		this.functionType = functionType;
	}
	@Override
	public String toString() {
		return "Chapter [categoryId=" + categoryId + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", tag=" + tag + ", chapterName=" + chapterName + ", hasVideo=" + hasVideo + ", hasChild="
				+ hasChild + ", parentId=" + parentId + ", isFree=" + isFree + ", tOrder=" + tOrder + ", functionType="
				+ functionType + "]";
	}
	
	
}
