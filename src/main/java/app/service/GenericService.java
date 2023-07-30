package app.service;

import java.util.List;

import app.model.CityDropdownDTO;

public interface GenericService {
	Boolean addCities();
	List<CityDropdownDTO> getAllCities();
}
