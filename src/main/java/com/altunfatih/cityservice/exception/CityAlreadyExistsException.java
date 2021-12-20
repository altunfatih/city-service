package com.altunfatih.cityservice.exception;

public class CityAlreadyExistsException extends RuntimeException {
	public CityAlreadyExistsException(String msg) {
		super(msg);
	}
}
