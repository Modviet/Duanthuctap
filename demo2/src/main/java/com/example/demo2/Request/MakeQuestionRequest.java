package com.example.demo2.Request;

public class MakeQuestionRequest {
	 private int userId;
	 private int subjectDetailId;
	 private String question;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSubjectDetailId() {
		return subjectDetailId;
	}
	public void setSubjectDetailId(int subjectDetailId) {
		this.subjectDetailId = subjectDetailId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}
