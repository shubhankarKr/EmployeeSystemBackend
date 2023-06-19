package app.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.DAO.SkillDAO;
import app.entity.SkillEntity;
import app.model.SkillDTO;
import jakarta.persistence.EntityManager;

@Repository
public class SkillDAOImpl implements SkillDAO{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Integer createSkill(SkillDTO skillDTO) {
		SkillEntity entity=skillDTO.createSkillEntity(skillDTO);
		entityManager.persist(entity);
		return entity.getSkillId();
	}

	@Override
	public SkillDTO updateSkill(SkillDTO skillDTO) {
		SkillEntity entity= entityManager.find(SkillEntity.class, skillDTO.getSkillId());
		if(entity != null) {
			entity.setEmpId(skillDTO.getEmpId());
			entity.setSkillName(skillDTO.getSkillName());
			
		}
		return entity.createSkillDTO(entity);
	}

	@Override
	public List<SkillDTO> getSkills() {
		Query query= (Query) entityManager.createQuery("select s from SkillEntity s");
	    List<SkillEntity> skillEntities= query.getResultList();
	    List<SkillDTO> skillDTOs=null;
	    if(skillEntities !=null) {
	    	skillDTOs=new ArrayList<>();
	    	for (SkillEntity entity : skillEntities) {
				SkillDTO dto=new SkillDTO();
				dto.setSkillId(entity.getSkillId());
				dto.setEmpId(entity.getEmpId());
				dto.setSkillName(entity.getSkillName());
				skillDTOs.add(dto);
			}
	    }
		return skillDTOs;
	}

	@Override
	public List<SkillDTO> updateSkillForEmployee(Integer empId, List<SkillDTO> skillDTO) {
		List<SkillDTO> res=new ArrayList<>();
		for (SkillDTO skillDTO2 : skillDTO) {
			SkillEntity entity=entityManager.find(SkillEntity.class, skillDTO2.getSkillId());
			if(entity!=null) {
				entity.setSkillName(skillDTO2.getSkillName());
			}else {
				entity=new SkillEntity();
				entity.setEmpId(empId);
				entity.setSkillName(skillDTO2.getSkillName());
				entityManager.persist(entity);
			}
			res.add(entity.createSkillDTO(entity));
		}
		return res;
	}
}
