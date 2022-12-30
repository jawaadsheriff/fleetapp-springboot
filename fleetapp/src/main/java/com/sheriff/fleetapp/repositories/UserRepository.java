package com.sheriff.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheriff.fleetapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
