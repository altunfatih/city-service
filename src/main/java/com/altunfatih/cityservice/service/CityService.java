package com.altunfatih.cityservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.altunfatih.cityservice.exception.CityAlreadyExistsException;
import com.altunfatih.cityservice.model.City;
import com.altunfatih.cityservice.repository.CityRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CityService {

	private final CityRepository cityRepository;
	
	public List<City> getCities() {
		return cityRepository.findAll();
	}
	
	public List<City> getCitiesByName(String name) {
		if (name == null)
			return cityRepository.findAll();
		else
			return cityRepository.findAllByName(name);
	}

	public City createCity(City newCity) {
        Optional<City> cityByName = cityRepository.findByName(newCity.getName());
        if (cityByName.isPresent()) {
            throw new CityAlreadyExistsException("City already exists with name: " + newCity.getName());
        }

        return cityRepository.save(newCity);

	}

	public void deleteById(String id) {
		cityRepository.deleteById(id);
	}

	public City getCityById(String id) {
	 	return cityRepository.findById(id)
	 			.orElseThrow(() -> new RuntimeException("City not found: " + id));
	}

	public void updateCity(String id, City newCity) {
		City oldCity = getCityById(id);
		oldCity.setName(newCity.getName());
		cityRepository.save(oldCity);
	}
}
