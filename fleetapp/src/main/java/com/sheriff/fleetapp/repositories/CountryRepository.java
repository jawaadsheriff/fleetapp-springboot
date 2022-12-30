package com.sheriff.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheriff.fleetapp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
