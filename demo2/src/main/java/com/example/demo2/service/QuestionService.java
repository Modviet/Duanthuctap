package com.example.demo2.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.DTO.QuestionDTO;
import com.example.demo2.Repository.QuestionRepository;
import com.example.demo2.Repository.SubjectDetailsRepository;
import com.example.demo2.Repository.iUser;
import com.example.demo2.Request.MakeQuestionRequest;
import com.example.demo2.model.MakeQuestion;
import com.example.demo2.model.Subject;
import com.example.demo2.model.SubjectDetail;
import com.example.demo2.model.User;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	private iUser userRepo;
	private SubjectDetailsRepository subDetailRepo;
	
	public QuestionDTO makeQuestion(MakeQuestionRequest request ) {
		MakeQuestion question = new MakeQuestion();
		User user = userRepo.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
		question.setUserId(user);
	    SubjectDetail subjectDetail=subDetailRepo.findById(request.getSubjectDetailId()).orElseThrow(()-> new RuntimeException("SubjectDetail not found"));
	    subjectDetail.setId(request.getUserId());
        question.setSubjectDetailId(subjectDetail);
        question.setQuestion(request.getQuestion());
        question.setCreateTime(LocalDateTime.now());
        MakeQuestion savedQuestion = questionRepo.save(question);
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(savedQuestion.getId());
        questionDTO.setUserId(savedQuestion.getUserId().getId());
        questionDTO.setSubjectDetailId(savedQuestion.getSubjectDetailId().getId());
        questionDTO.setQuestion(savedQuestion.getQuestion());
        questionDTO.setCreateTime(savedQuestion.getCreateTime());
        questionDTO.setUpdateTime(savedQuestion.getUpdateTime());

        return questionDTO;
	}
}
