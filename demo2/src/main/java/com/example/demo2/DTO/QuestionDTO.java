package com.example.demo2.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class QuestionDTO {
	    private int Id;
	    private String Question;
	    private int userId;
	    private int subjectDetailId;
	    private int NumberOfAnswers;
	    private LocalDateTime CreateTime;
	    private LocalDate UpdateTime;
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		
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
			return Question;
		}
		public void setQuestion(String question) {
			Question = question;
		}
		public int getNumberOfAnswers() {
			return NumberOfAnswers;
		}
		public void setNumberOfAnswers(int numberOfAnswers) {
			NumberOfAnswers = numberOfAnswers;
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
}
