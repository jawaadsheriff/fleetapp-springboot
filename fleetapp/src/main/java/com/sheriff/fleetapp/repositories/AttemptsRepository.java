package com.sheriff.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheriff.fleetapp.models.Attempts;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Integer>{
	
	Attempts findAttemptsByUsername(String Username);
}
