package com.example.appointmentscheduling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="appointments")
public class AppointmentScheduling {
	@Id
	@Column(name="truck_number")
	private int truckNumber;
	@Column(name="dc_number")
	private int dcNumber;
	@Column(name="dc_slot_number")
	private int dcSlotNumber;
	@Column(name="po_number")
	private int poNumber;
	@Column(name="date_of_appointment")
	private String DateOfAppointment;
}
