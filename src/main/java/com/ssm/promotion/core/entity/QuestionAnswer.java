package com.ssm.promotion.core.entity;

public class QuestionAnswer {
	private int id;
	private int correct;
	private String  answer;
	private String stem;
	private Integer questionId;
	private int chapterId;
	private String chapterName;
	private int courseId;
	private String courseName;
	private  int  aOrder;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public String getStem() {
		return stem;
	}
	public void setStem(String stem) {
		this.stem = stem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
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
	public int getaOrder() {
		return aOrder;
	}
	public void setaOrder(int aOrder) {
		this.aOrder = aOrder;
	}
	@Override
	public String toString() {
		return "QuestionAnswer [id=" + id + ", correct=" + correct + ", answer=" + answer + ", stem=" + stem
				+ ", questionId=" + questionId + ", chapterId=" + chapterId + ", chapterName=" + chapterName
				+ ", courseId=" + courseId + ", courseName=" + courseName + ", aOrder=" + aOrder + "]";
	}
	
}
