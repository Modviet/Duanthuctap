package com.example.demo2.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.DTO.AnswerDTO;
import com.example.demo2.Repository.AnswerRepository;
import com.example.demo2.Repository.QuestionRepository;
import com.example.demo2.Request.ReplyAnswerRequest;
import com.example.demo2.model.Answers;
import com.example.demo2.model.MakeQuestion;
import com.example.demo2.model.User;

@Service
public class AnswersService {
	@Autowired
	private  AnswerRepository answerRepo;
	private QuestionRepository questionRepo;
	
	public AnswerDTO replyAnswer(ReplyAnswerRequest request) {
        Answers answer = new Answers();
        User user = new User();
	    user.setId(request.getUserId());
        answer.setUserId(user);
        MakeQuestion question = questionRepo.findById(request.getQuestionId()).orElseThrow(()-> new RuntimeException("Question not found")) ;
        question.setId(request.getQuestionId());
        answer.setQuestionId(question);
        answer.setAnswer(request.getAnswer());
        answer.setCreateTime(LocalDateTime.now());

        Answers savedAnswer = answerRepo.save(answer);

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(savedAnswer.getId());
        answerDTO.setQuestionId(savedAnswer.getQuestionId().getId());
        answerDTO.setUserId(savedAnswer.getUserId().getId());
        answerDTO.setAnswer(savedAnswer.getAnswer());
        answerDTO.setCreateTime(savedAnswer.getCreateTime());
        answerDTO.setUpdateTime(savedAnswer.getUpdateTime());

        return answerDTO;
    }
}
