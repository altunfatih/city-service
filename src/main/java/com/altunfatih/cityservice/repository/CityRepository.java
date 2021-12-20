package com.altunfatih.cityservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.altunfatih.cityservice.model.City;

public interface CityRepository extends MongoRepository<City, String> {
	List<City> findAllByName(String name);
	Optional<City> findByName(String name);
}
