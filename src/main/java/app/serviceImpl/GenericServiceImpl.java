package app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.DAO.GenericDAO;
import app.model.CityDropdownDTO;
import app.service.GenericService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GenericServiceImpl implements GenericService{
	
	@Autowired
	GenericDAO genericDAO;

	@Override
	public Boolean addCities() {
		// TODO Auto-generated method stub
		return genericDAO.addCities();
	}

	@Override
	public List<CityDropdownDTO> getAllCities() {
		// TODO Auto-generated method stub
		return genericDAO.getAllCities();
	}
	
	
	
}
