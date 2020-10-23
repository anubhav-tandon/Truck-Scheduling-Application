package com.example.dc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dc.exception.DcNotExistsException;
import com.example.dc.exception.DcNumberNotFoundException;
import com.example.dc.model.Dc;
import com.example.dc.repository.DcRepository;

@Service
public class DcService {

	@Autowired
	DcRepository dcRepo;

	@Cacheable(value = "dcs")
	public List<Dc> getAllDc() {
		return dcRepo.findAll();
	}

	@Cacheable(value = "dcs", key = "dcs.id")
	public Dc addDc(Dc dc) {
		dc.setDcCity(dc.getDcCity());
		dc.setDcNumber(dc.getDcNumber());
		dc.setDcType(dc.getDcType());
		return dcRepo.save(dc);
	}

	@CachePut(value = "dcs", key = "dcs.id")
	public Dc updateDc(Dc dc) {
		Dc item = dcRepo.findById(dc.getDcNumber()).get();
		item.setDcCity(dc.getDcCity());
		item.setDcNumber(dc.getDcNumber());
		item.setDcType(dc.getDcType());
		return dcRepo.save(item);
	}

	@CacheEvict(value = "dcs", key = "dcs.id")
	public void deleteDc(Integer id) throws DcNotExistsException, DcNumberNotFoundException {
		dcRepo.deleteById(id);
	}

	@Cacheable(value = "dcs", key = "dcs.id")
	public Optional<Dc> getDc(int id) {
		return dcRepo.findById(id);
	}
}
