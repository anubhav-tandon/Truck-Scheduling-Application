package com.example.appointmentscheduling.modeldto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DcSlots {
	private int dcNumber;
	private String timeSlot;
	private int maxTrucks;
//	private LocalDateTime initialTime = LocalDateTime.parse(rimeSlot);
//	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//	//private LocalDateTime finalTimeSlot =LocalDateTime.of(formatter).plus(1,ChronoUnit.HOURS);
//	private String formatedTimeSlot = initialTime.format(formatter);
}
