package com.example.demo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.DTO.QuestionDTO;
import com.example.demo2.Request.MakeQuestionRequest;
import com.example.demo2.Service.QuestionService;

@RestController
@RequestMapping(value="question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping(value="/make")
	public ResponseEntity<?> makeQuestion(@RequestBody MakeQuestionRequest request) {
		try {
				QuestionDTO questionDTO = questionService.makeQuestion(request);
	            return ResponseEntity.ok(questionDTO);
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Failed to make question: " + ex.getMessage());
	        }
	    }  
}
