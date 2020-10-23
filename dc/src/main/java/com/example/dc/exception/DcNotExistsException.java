package com.example.dc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Dc Not Found")
public class DcNotExistsException extends Exception {
	public DcNotExistsException(String msg) {
		super(msg);
	}

}
