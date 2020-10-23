package com.example.truck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.truck.model.Truck;
import com.example.truck.repository.TruckRepository;

@Service
public class TruckService {
	@Autowired
	TruckRepository truckRepository;
	public List<Truck> getAllTrucks(){
		return truckRepository.findAll();
	}
	public Truck addTruck(Truck truck) { 
		truck.setTruckNumber(truck.getTruckNumber());
		truck.setTruckName(truck.getTruckName());
		truck.setTruckType(truck.getTruckType());
		return truckRepository.save(truck);
	}
	public Truck updateTruck(Truck truck) {
		Truck item = truckRepository.findById(truck.getTruckNumber()).get();
		item.setTruckNumber(truck.getTruckNumber());
		item.setTruckName(truck.getTruckName());
		item.setTruckType(truck.getTruckType());
		return truckRepository.save(item);
	}
	public void deleteTruck(Integer id){
		 truckRepository.deleteById(id);
	}
	public Optional<Truck> getTruck(int id) {
		return truckRepository.findById(id);
	}

}
