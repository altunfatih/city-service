package com.altunfatih.cityservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altunfatih.cityservice.exception.CityAlreadyExistsException;
import com.altunfatih.cityservice.exception.CityNotFoundException;
import com.altunfatih.cityservice.model.City;
import com.altunfatih.cityservice.service.CityService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cities")
public class CityController {

	private final CityService cityService;
	
	@GetMapping("/list")
	public ResponseEntity<List<City>> getCities() {
		return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
	}
	
	@GetMapping("/list/{name}")
	public ResponseEntity<List<City>> getCitiesByName(@PathVariable String name) {
		return new ResponseEntity<>(cityService.getCitiesByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<City> getCitiesById(@PathVariable String id) {				
		return new ResponseEntity<>(cityService.getCityById(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<City> createCity(@RequestBody City newCity) {
		return new ResponseEntity<City>(cityService.createCity(newCity), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateCity(@PathVariable String id, @RequestBody City newCity) {		
		cityService.updateCity(id, newCity);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable String id) {
		cityService.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<String> handleCityNotFoundException(CityNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(CityAlreadyExistsException.class)
    public ResponseEntity<String> handleIlIlAlreadyExistsException(CityAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

	
}