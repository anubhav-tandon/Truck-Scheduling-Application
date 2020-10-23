package com.example.dc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dc.model.Dc;

@Repository
public interface DcRepository extends JpaRepository<Dc, Integer> {
	Dc findByDcNumber(Integer dcNumber);
	// findById(Integer dcNumber);

}
