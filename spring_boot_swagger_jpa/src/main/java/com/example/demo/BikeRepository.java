package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface to connect database operation
public interface BikeRepository extends JpaRepository<Bike, Integer> {
	public Optional<Bike> findById(Integer id);
}
