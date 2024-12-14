package vn.edu.iuh.nguyentheluc_21046661_week05.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.JobSkill;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Skill;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder

public class JobDTO {
    private String name;
    private String description;
    private List<JobSkillDTO> jobSkills;
}
