package com.altunfatih.cityservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	@Id
	private String id;
	
	private Date createDate = new Date();
	
	private String name;
}
