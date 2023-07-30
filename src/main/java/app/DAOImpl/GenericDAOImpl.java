package app.DAOImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.DAO.GenericDAO;
import app.model.CityDropdownDTO;
import app.model.entity.CityDropdown;
import jakarta.persistence.EntityManager;

@Repository
public class GenericDAOImpl implements GenericDAO{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Boolean addCities() {
		try {
			File file=new File("cities.txt");
			FileReader reader=new FileReader(file);
			BufferedReader br=new BufferedReader(reader);
			String line;
			CityDropdown entity=null;
			while((line = br.readLine())!=null) {
				entity=new CityDropdown();
				entity.setCityName(line);
				entityManager.persist(entity);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<CityDropdownDTO> getAllCities() {
		
		List<CityDropdownDTO> dtos=new ArrayList<>();
		Query query= (Query) entityManager.createQuery("select c from CityDropdown c");
		List<CityDropdown> entiList=query.getResultList();
		for (CityDropdown cityDropdown : entiList) {
			CityDropdownDTO dto=new CityDropdownDTO();
			dto.setCityName(cityDropdown.getCityName());
			dto.setCityId(cityDropdown.getCityId());
			dtos.add(dto);
		}
		return dtos;
	}
	
}
