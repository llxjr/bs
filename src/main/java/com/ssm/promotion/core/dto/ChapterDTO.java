package com.ssm.promotion.core.dto;

import java.util.Date;

import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Course;
public class ChapterDTO {
	private int id;
	private Category category;
	private String chapterName;
	private String tag;
	private int courseId;
	private String courseName;
	private int hasVideo;
	private int hasChild;
	private int parentId;
	private int isFree;
	private int tOrder;
	private int functionType;
	private Date createTime;
	private String createBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	@Override
	public String toString() {
		return "ChapterDTO [category=" + category + ", chapterName=" + chapterName + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", hasVideo=" + hasVideo + ", hasChild=" + hasChild + ", parentId="
				+ parentId + ", isFree=" + isFree + ", tOrder=" + tOrder + ", functionType=" + functionType
				+ ", createTime=" + createTime + ", createBy=" + createBy + "]";
	}


}
