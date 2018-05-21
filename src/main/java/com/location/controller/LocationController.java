package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.entities.Location;
import com.location.service.LocationService;
import com.location.util.EmailUtil;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService service;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/")
	public String home() {
		return "Location Rest API";
	}
	
	@RequestMapping("/create")
	public Location create() {
		/*Location location = new Location();
		location.setId(1);
		location.setName("Gurgoan");
		location.setCode("GG");
		location.setType("Metro");
		return service.saveLocation(location);*/
		
		
		/*Location location = new Location();
		location.setId(2);
		location.setName("Noida");
		location.setCode("ND");
		location.setType("Metro");
		return service.saveLocation(location);*/
		
		emailUtil.sendEmail("spring2205mail@gmail.com", "spring-mail-test : Location Saved", "Location saved successfully");
		
		Location location = new Location();
		location.setId(3);
		location.setName("Delhi");
		location.setCode("DL");
		location.setType("MetroCity");
		return service.saveLocation(location);
	}
	
	@RequestMapping("/update")
	public Location update() {
		Location location = service.getLocationById(1);
		location.setType("MetroCity");
		return service.saveLocation(location);
	}
	
	@RequestMapping("/findAll")
	public List<Location> findAll() {
		return service.getAllLocations();
	}
	
	@RequestMapping("/delete")
	public String delete() {
		Location location = service.getLocationById(2);
		service.deleteLocation(location);
		return "Location Deleted";
	}
	
	@RequestMapping("/read")
	public Location read() {
		int id = 1;
		return service.getLocationById(id);
	}
	
	

}
