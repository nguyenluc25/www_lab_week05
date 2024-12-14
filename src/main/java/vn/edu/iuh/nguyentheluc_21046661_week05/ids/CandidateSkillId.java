package vn.edu.iuh.nguyentheluc_21046661_week05.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CandidateSkillId {

    @Column(name = "candidate_id")
    private long candidateId;

    @Column(name = "skill_id")
    private long skillId;
}
