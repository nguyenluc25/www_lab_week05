package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.SkillLevel;
import vn.edu.iuh.nguyentheluc_21046661_week05.ids.JobSkillId;

@Entity
@Table(name = "job_skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JobSkill {

    @EmbeddedId
    private JobSkillId id;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfo;

    @Column(name = "skill_level")
    private SkillLevel skillLevel;
}
