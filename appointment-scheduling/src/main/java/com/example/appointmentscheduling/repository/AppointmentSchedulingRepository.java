package com.example.appointmentscheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appointmentscheduling.model.AppointmentScheduling;

public interface AppointmentSchedulingRepository extends JpaRepository<AppointmentScheduling, Integer> {

}
