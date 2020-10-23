package com.example.truck.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.truck.model.Truck;
@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer>{
	Optional<Truck> findById(Integer id);

}
