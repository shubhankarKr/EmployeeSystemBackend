package app.entity;


import app.model.SkillDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "skill")
@Entity
public class SkillEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skill_id")
	private Integer skillId;
	
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "skill_name")
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

	public SkillDTO createSkillDTO(SkillEntity entity) {
		SkillDTO dto=new SkillDTO();
		dto.setSkillId(entity.getSkillId());
		dto.setEmpId(entity.getEmpId());
		dto.setSkillName(entity.getSkillName());
		return dto;
	}
	
}
