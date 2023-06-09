package app.model;

import app.entity.SkillEntity;

public class SkillDTO {
	private Integer skillId;
	private Integer empId;
	private String skillName;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public SkillEntity createSkillEntity(SkillDTO skillDTO) {
		SkillEntity entity=new SkillEntity();
		entity.setEmpId(skillDTO.getEmpId());
		entity.setSkillName(skillDTO.getSkillName());
		return entity;
	}
}
