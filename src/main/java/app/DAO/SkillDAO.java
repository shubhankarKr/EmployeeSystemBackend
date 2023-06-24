package app.DAO;

import java.util.List;

import app.model.SkillDTO;

public interface SkillDAO {
		public Integer createSkill(SkillDTO skillDTO);
		public SkillDTO updateSkill(SkillDTO skillDTO);
		public List<SkillDTO> getSkills();
		public List<SkillDTO> addSkillForEmployee(Integer empId,List<SkillDTO> skillDTO);
		public Boolean deleteSkillForEmployee(Integer empId);
}
