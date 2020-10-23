package com.example.dcslots.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dcslots.model.DcSlots;
@Repository
public interface DcSlotsRepository extends JpaRepository<DcSlots, Integer> {
	DcSlots findByDcNumber(Integer id);
	//Optional<DcSlots> findById(Integer id);

}
