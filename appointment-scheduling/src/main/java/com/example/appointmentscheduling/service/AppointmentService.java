package com.example.appointmentscheduling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointmentscheduling.model.AppointmentScheduling;
import com.example.appointmentscheduling.modeldto.DcSlots;
import com.example.appointmentscheduling.modeldto.Truck;
import com.example.appointmentscheduling.repository.AppointmentSchedulingRepository;
import com.example.appointmentscheduling.restclients.DcSlotsClient;
import com.example.appointmentscheduling.restclients.TruckClient;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class AppointmentService {
	
	@Autowired
	AppointmentSchedulingRepository appointmentRepo;
	@Autowired
	DcSlotsClient dcSlotsClient;
	@Autowired
	TruckClient truckClient;
	public List<AppointmentScheduling> getAllAppointments(){
		return appointmentRepo.findAll();
	}
	public AppointmentScheduling addAppointment(AppointmentScheduling appointmentScheduling) {
		DcSlots dcSlots=dcSlotsClient.getDcSlotsDetail(appointmentScheduling.getDcNumber());
		Truck truck=truckClient.getTrucksDetail(appointmentScheduling.getTruckNumber());
		log.info("---------",appointmentScheduling.getDcNumber());
		try {
		appointmentScheduling.setTruckNumber(appointmentScheduling.getTruckNumber());
		appointmentScheduling.setDateOfAppointment(appointmentScheduling.getDateOfAppointment());
		appointmentScheduling.setDcNumber(appointmentScheduling.getDcNumber());
		appointmentScheduling.setDcSlotNumber(appointmentScheduling.getDcSlotNumber());
		appointmentScheduling.setPoNumber(appointmentScheduling.getPoNumber());
		int count=0;
		if(truck.getTruckType()=="Recliner") //increase count+1
		if(dcSlots.getMaxTrucks()==count) { //and po is present
			//give kafka that slots full
		}
		System.out.println(truck.getTruckType());
		return appointmentRepo.save(appointmentScheduling);
		}
		catch(FeignException ex) {
			ex.printStackTrace();
		} 

		return null;
	}
	public AppointmentScheduling updateAppointment(AppointmentScheduling appointmentScheduling) {
		AppointmentScheduling item = appointmentRepo.findById(appointmentScheduling.getDcNumber()).get();
		item.setTruckNumber(appointmentScheduling.getTruckNumber());
		item.setDateOfAppointment(appointmentScheduling.getDateOfAppointment());
		item.setDcNumber(appointmentScheduling.getDcNumber());
		item.setDcSlotNumber(appointmentScheduling.getDcSlotNumber());
		item.setPoNumber(appointmentScheduling.getPoNumber());
		return appointmentRepo.save(item);
	}

	public void deleteAppointment(Integer id){
		appointmentRepo.deleteById(id);
	}

	public Optional<AppointmentScheduling> getAppointment(int id) {
		return appointmentRepo.findById(id);
	}
//	public DcSlots getDcslotsDetail() {
//		return dcSlotsClient.getDcSlotsDetail(dcNumber); //in controller from @postmapping send obj of appointment and use dcnumber
//	}
//	@PostMapping("/feign")
//	public AnalyticalEnv create(@RequestBody AnalyticalEnv analyticalEnv) {
//	Subscriptions subscriptions=subscriptionsClient.getSubscriptions(analyticalEnv.getMenuItemCode());
//	if(analyticalEnv.getName().equals(subscriptions.getName()));
//	analyticalEnv.setBought(analyticalEnv.getBought()+1);
//	return analyticalEnvRepository.save(analyticalEnv);
//}
}
