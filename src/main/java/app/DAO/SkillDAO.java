package app.DAO;

import java.util.List;

import app.model.SkillDTO;

public interface SkillDAO {
		public Integer createSkill(SkillDTO skillDTO);
		public SkillDTO updateSkill(SkillDTO skillDTO);
		public List<SkillDTO> getSkills();
}