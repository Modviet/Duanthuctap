package com.example.demo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.DTO.AnswerDTO;
import com.example.demo2.Request.ReplyAnswerRequest;
import com.example.demo2.Service.AnswersService;

@RestController
@RequestMapping(value="answer")
public class AnswerController {
	@Autowired
	private  AnswersService answerService;

    public AnswerController(AnswersService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/reply")
    public ResponseEntity<?> replyQuestion(@RequestBody ReplyAnswerRequest request) {
        try {
            AnswerDTO answerDTO = answerService.replyAnswer(request);
            return ResponseEntity.ok(answerDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to reply answer: " + ex.getMessage());
        }
    }
}
