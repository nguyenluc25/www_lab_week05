package vn.edu.iuh.nguyentheluc_21046661_week05.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Candidate;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Job;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Skill;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class JobResponseDTO {
    private Job job;
    private String skills;
    private String skillToLearn;
}
