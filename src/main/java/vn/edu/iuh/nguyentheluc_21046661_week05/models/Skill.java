package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.SkillType;

import java.util.List;

@Entity
@Table(name = "skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", length = 20)
    private long id;

    @Column(name = "skill_name", length = 150)
    private String skillName;

    @Column(name = "skill_desc", length = 300)
    private String skillDescription;

    @Column(name = "skill_type")
    private SkillType type;

    @OneToMany(mappedBy = "skill")
    @ToString.Exclude
    private List<JobSkill> jobSkills;

    @OneToMany(mappedBy = "skill")
    @ToString.Exclude
    private List<CandidateSkill> candidateSkills;
}
