package vn.edu.iuh.nguyentheluc_21046661_week05.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JobSkillId implements Serializable {

    @Column(name = "job_id")
    private long jobId;

    @Column(name = "skill_id")
    private long skillId;
}
