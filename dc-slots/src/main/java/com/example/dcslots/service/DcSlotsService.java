package com.example.dcslots.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dcslots.model.DcSlots;
import com.example.dcslots.repository.DcSlotsRepository;

@Service
public class DcSlotsService{
	@Autowired
	DcSlotsRepository dcSlotsRepo;
	public List<DcSlots> getAllDcSlots(){
		return dcSlotsRepo.findAll();
	}
	public DcSlots addDcSlots(DcSlots dcSlots) { 
		dcSlots.setDcNumber(dcSlots.getDcNumber());
		dcSlots.setTimeSlot(dcSlots.getTimeSlot());
		dcSlots.setMaxTrucks(dcSlots.getMaxTrucks());
		return dcSlotsRepo.save(dcSlots);
	}
	public DcSlots updateDcSlots(DcSlots dcSlots) {
		DcSlots item = dcSlotsRepo.findById(dcSlots.getDcNumber()).get();
		item.setDcNumber(dcSlots.getDcNumber());
		item.setTimeSlot(dcSlots.getTimeSlot());
		item.setMaxTrucks(dcSlots.getMaxTrucks());
		return dcSlotsRepo.save(item);
	}
	public void deleteDcSlots(Integer id) {
		 dcSlotsRepo.deleteById(id);
	}
	public Optional<DcSlots> getDcSlots(int id){
		return dcSlotsRepo.findById(id);
	}
}
