package com.ssm.promotion.core.entity;

import com.ssm.promotion.core.entity.base.BaseEntity;

public class Paper extends BaseEntity {
	private int courseId;
	private int belongType;
	private String paperName;
	private int duration;
	private int totalValue;
	private int nowValue;
	private int questionNumber;
	private int isDel;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getBelongType() {
		return belongType;
	}
	public void setBelongType(int belongType) {
		this.belongType = belongType;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	public int getNowValue() {
		return nowValue;
	}
	public void setNowValue(int nowValue) {
		this.nowValue = nowValue;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
}
