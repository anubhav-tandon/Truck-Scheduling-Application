package com.example.appointmentscheduling.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.appointmentscheduling.modeldto.DcSlots;

@FeignClient(name="dcslots-service" , url="http://localhost:8082")
public interface DcSlotsClient {
	@GetMapping("/dcslots/{dcNumber}")
	DcSlots getDcSlotsDetail(@PathVariable("dcNumber")  int dcNumber); 
}
