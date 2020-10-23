package com.example.dc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="dc")
public class Dc {
	@Id
	@Column(name="dc_number")
	private Integer dcNumber;
	@Column(name="dc_city")
	private String dcCity;
	@Column(name="dc_type")
	private String dcType;

}
