package com.CodeWarriors.GoldenTrainers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeWarriors.GoldenTrainers.model.Pedidos;


public interface OrderRepository extends JpaRepository<Pedidos, Long> {
	
}