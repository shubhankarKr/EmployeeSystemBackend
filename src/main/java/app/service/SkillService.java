package app.service;

import java.util.List;

import app.model.SkillDTO;

public interface SkillService {
	public Integer createSkill(SkillDTO skillDTO);
	public SkillDTO updateSkill(SkillDTO skillDTO);
	public List<SkillDTO> getSkills();
}
