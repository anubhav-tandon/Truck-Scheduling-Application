package com.example.appointmentscheduling.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.appointmentscheduling.modeldto.Truck;

@FeignClient(name="truck-service", url="http://localhost:8084")
public interface TruckClient {
	@GetMapping("/truck/{truckNumber}")
	Truck getTrucksDetail(@PathVariable("truckNumber")  int truckNumber); 

}
