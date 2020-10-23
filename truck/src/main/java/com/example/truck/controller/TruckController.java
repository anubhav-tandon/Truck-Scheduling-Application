package com.example.truck.controller;

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

import com.example.truck.exception.TruckNotFoundException;
import com.example.truck.model.Truck;
import com.example.truck.service.TruckService;

@RestController
@RequestMapping("/truck")
public class TruckController {
	@Autowired
	TruckService truckService;
	@GetMapping("/all")
	public List<Truck> getAllTrucks(){
		return truckService.getAllTrucks();
	}
	@PostMapping("/add")
	public ResponseEntity<Truck> addTruck(@RequestBody Truck truck) {
		return ResponseEntity.status(HttpStatus.CREATED).body(truckService.addTruck(truck));
	}
	@PutMapping("/update")
	public ResponseEntity<Truck> updateTruck(@RequestBody Truck truck) throws TruckNotFoundException {
		return ResponseEntity.ok(truckService.updateTruck(truck));
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTruck(@PathVariable Integer id) throws TruckNotFoundException{
	 truckService.deleteTruck(id);
	}
	@GetMapping("/search/{id}")
	public Optional<Truck> getTruck(@PathVariable int id) throws TruckNotFoundException {
		return truckService.getTruck(id);
	}
}
