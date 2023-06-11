package app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.DAO.SkillDAO;
import app.model.SkillDTO;
import app.service.SkillService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillDAO skillDAO;

	@Override
	public Integer createSkill(SkillDTO skillDTO) {
		return skillDAO.createSkill(skillDTO);
	}

	@Override
	public SkillDTO updateSkill(SkillDTO skillDTO) {
		return skillDAO.updateSkill(skillDTO);
	}

	@Override
	public List<SkillDTO> getSkills() {
		return skillDAO.getSkills();
	}

}
