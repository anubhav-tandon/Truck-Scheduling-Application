package com.example.appointmentscheduling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Dc Not Found")
public class ApointmentNotExistsException extends Exception {
	public ApointmentNotExistsException(String msg) {
		super(msg);
	}

}
