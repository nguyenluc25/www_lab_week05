package vn.edu.iuh.nguyentheluc_21046661_week05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.nguyentheluc_21046661_week05.ids.JobSkillId;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Job;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.JobSkill;

import java.util.List;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    List<JobSkill> findByJobId(Long jobId);

    List<JobSkill> findBySkillId(Long skillId);
}
