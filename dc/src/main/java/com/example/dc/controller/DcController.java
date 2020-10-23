package com.example.dc.controller;

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

import com.example.dc.exception.DcNotExistsException;
import com.example.dc.exception.DcNumberNotFoundException;
import com.example.dc.model.Dc;
import com.example.dc.service.DcService;

@RestController
@RequestMapping("/dc")
public class DcController {
	
	@Autowired
	private DcService dcService;
	@GetMapping("/all")
	public ResponseEntity<List<Dc>> getAllDc(){
		return ResponseEntity.ok(dcService.getAllDc());
	}

	@PostMapping("/add")
	public ResponseEntity<Dc> addDc(@RequestBody Dc dc) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dcService.addDc(dc));
	}

	@PutMapping("/update")
	public ResponseEntity<Dc> updateDc(@RequestBody Dc dc) throws DcNotExistsException, DcNumberNotFoundException {
		return ResponseEntity.ok(dcService.updateDc(dc));
	}

	@DeleteMapping("/delete/{id}")
	public void deleteDc(@PathVariable Integer id) throws DcNotExistsException, DcNumberNotFoundException {
		dcService.deleteDc(id);
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<Optional<Dc>> getDc(@PathVariable int id) throws DcNotExistsException, DcNumberNotFoundException {
		return ResponseEntity.ok(dcService.getDc(id));
	}
}
