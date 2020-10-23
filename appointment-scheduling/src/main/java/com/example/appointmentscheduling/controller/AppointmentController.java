package com.example.appointmentscheduling.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointmentscheduling.exception.ApointmentNotExistsException;
import com.example.appointmentscheduling.model.AppointmentScheduling;
import com.example.appointmentscheduling.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@GetMapping("/all")
	public List<AppointmentScheduling> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	@PostMapping("/add")
	public ResponseEntity<AppointmentScheduling> addAppointment(@RequestBody AppointmentScheduling dc) {
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointment(dc));
	}

	@PutMapping("/update")
	public ResponseEntity<AppointmentScheduling> updateAppointment(@RequestBody AppointmentScheduling dc) throws ApointmentNotExistsException{
		return ResponseEntity.ok(appointmentService.updateAppointment(dc));
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAppointment(@PathVariable Integer id) throws ApointmentNotExistsException{
		appointmentService.deleteAppointment(id);
	}

	@GetMapping("/search/{id}")
	public Optional<AppointmentScheduling> getAppointment(@PathVariable int id) throws ApointmentNotExistsException{
		return appointmentService.getAppointment(id);
	}

}
