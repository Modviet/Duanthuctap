package com.example.demo2.Exception;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String message) {
        super(message);
    }
}
