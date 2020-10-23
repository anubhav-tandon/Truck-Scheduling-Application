package com.example.dcslots.controller;

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

import com.example.dcslots.exception.DcSlotNotExistsException;
import com.example.dcslots.model.DcSlots;
import com.example.dcslots.service.DcSlotsService;

@RestController
@RequestMapping("/dcslots")
public class DcSlotsController {
	@Autowired
	DcSlotsService dcSlotsService;
	@GetMapping("/all")
	public List<DcSlots> getAllDcSlots(){
		return dcSlotsService.getAllDcSlots();
	}
	@PostMapping("/add")
	public ResponseEntity<DcSlots> addDcSlots(@RequestBody DcSlots dcSlots) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dcSlotsService.addDcSlots(dcSlots));
	}
	@PutMapping("/update")
	public ResponseEntity<DcSlots> updateDcSlots(@RequestBody DcSlots dcSlots) throws DcSlotNotExistsException {
		return ResponseEntity.ok(dcSlotsService.updateDcSlots(dcSlots));
	}
	@DeleteMapping("/delete/{id}")
	public void deleteDcSlots(@PathVariable Integer id) throws DcSlotNotExistsException{
	 dcSlotsService.deleteDcSlots(id);
	}
	@GetMapping("/search/{id}")
	public Optional<DcSlots> getDcSlots(@PathVariable int id) throws DcSlotNotExistsException{
		return dcSlotsService.getDcSlots(id);
	}

}
