package com.example.dcslots.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dcslots")
public class DcSlots {
	@Id
	@Column(name="dc_number")
	private int dcNumber;
	@Column(name="dc_timeslot")
	private String timeSlot;
	@Column(name="dc_max_trucks")
	private int maxTrucks;
//	private LocalDateTime initialTime = LocalDateTime.parse(rimeSlot);
//	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//	//private LocalDateTime finalTimeSlot =LocalDateTime.of(formatter).plus(1,ChronoUnit.HOURS);
//	private String formatedTimeSlot = initialTime.format(formatter);
}
