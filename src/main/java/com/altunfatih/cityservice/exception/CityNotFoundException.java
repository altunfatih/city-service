package com.altunfatih.cityservice.exception;

public class CityNotFoundException extends RuntimeException {
	public CityNotFoundException(String msg) {
		super(msg);
	}
}
