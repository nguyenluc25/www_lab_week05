package vn.edu.iuh.nguyentheluc_21046661_week05.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.SkillLevel;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Skill;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class JobSkillDTO {
    private Long skillId = 0L;
    private String skillLevel;
    private String moreInfor;
}
