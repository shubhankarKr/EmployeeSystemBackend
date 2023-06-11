package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.SkillDTO;
import app.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@PostMapping("/create")
	public Integer createSkill(@RequestBody SkillDTO skillDTO) {
		return skillService.createSkill(skillDTO);
		
	}
	@PutMapping("/update")
	public SkillDTO updateSkill(@RequestBody SkillDTO skillDTO) {
		return skillService.updateSkill(skillDTO);
	}
	
	@GetMapping("/getAllSkills")
	public List<SkillDTO> getSkills(){
		return skillService.getSkills();
	}
}
