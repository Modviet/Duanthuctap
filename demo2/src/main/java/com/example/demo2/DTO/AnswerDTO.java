package com.example.demo2.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class AnswerDTO {
    private int Id;
    private int questionId;
    private int userId;
    private String Answer;
    private LocalDateTime CreateTime;
    public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public LocalDateTime getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(LocalDateTime localDateTime) {
		CreateTime = localDateTime;
	}
	public LocalDate getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(LocalDate updateTime) {
		UpdateTime = updateTime;
	}
	private LocalDate UpdateTime;
}
