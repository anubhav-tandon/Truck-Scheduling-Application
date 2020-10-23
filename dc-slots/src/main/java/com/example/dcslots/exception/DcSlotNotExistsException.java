package com.example.dcslots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Dc Not Found")
public class DcSlotNotExistsException extends Exception {
	public DcSlotNotExistsException(String msg) {
		super(msg);
	}

}
