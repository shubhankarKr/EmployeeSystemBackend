package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.CityDropdownDTO;
import app.service.GenericService;

@RestController
@RequestMapping("/generic")
public class GenericController {
	
	@Autowired
	GenericService genericService;
	
	@PostMapping(path = "/addCities")
	Boolean addCities() {
		return genericService.addCities();
	}
	
	@GetMapping("/getAllCities")
	List<CityDropdownDTO> getAllCities() {
		return genericService.getAllCities();
	}
}
