package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.SkillLevel;
import vn.edu.iuh.nguyentheluc_21046661_week05.ids.CandidateSkillId;

@Entity
@Table(name = "candidate_skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CandidateSkill {

    @EmbeddedId
    private CandidateSkillId id;

    @ManyToOne
    @JoinColumn(name = "skill_id", insertable=false, updatable=false)
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "candidate_id", insertable=false, updatable=false)
    private Candidate candidate;

    @Column(name = "more_infos", length = 1000)
    private String moreInfo;

    @Column(name = "skill_level")
    private SkillLevel skillLevel;
}
