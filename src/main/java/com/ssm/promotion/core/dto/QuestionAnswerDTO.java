package com.ssm.promotion.core.dto;

import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Course;
import com.ssm.promotion.core.entity.Question;
import com.ssm.promotion.core.entity.QuestionAnswer;

public class QuestionAnswerDTO extends QuestionAnswer{
	private Question question;
	private Chapter chapter;
	private Course course;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "QuestionAnswerDTO [question=" + question  + ", chapter=" + chapter + ", course="
				+ course + "]";
	}
}
