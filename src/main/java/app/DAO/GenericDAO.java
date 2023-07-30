package app.DAO;

import java.util.List;

import app.model.CityDropdownDTO;

public interface GenericDAO {
	Boolean addCities();
	List<CityDropdownDTO> getAllCities();
}
