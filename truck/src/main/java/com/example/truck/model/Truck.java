package com.example.truck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="truck")
public class Truck {
	//truck type (Straight Truck, Flatbed (Flat Bed) Trailers, Conestoga Trailers, Refrigerated (Reefer) Trailers)
	@Id 
	@Column(name="truck_number")
	private int truckNumber;
	@Column(name="truck_name")
	private String truckName;
	@Column(name="truck_type")
	private String truckType;

}
