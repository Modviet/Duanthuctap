package com.example.demo2.DTO;

public class LearningProgressDTO {
	private int id;
    private int userId;
    private int registerStudyId;
    private int currentSubjectId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRegisterStudyId() {
		return registerStudyId;
	}
	public void setRegisterStudyId(int registerStudyId) {
		this.registerStudyId = registerStudyId;
	}
	public int getCurrentSubjectId() {
		return currentSubjectId;
	}
	public void setCurrentSubjectId(int currentSubjectId) {
		this.currentSubjectId = currentSubjectId;
	}
}
