package vn.edu.iuh.nguyentheluc_21046661_week05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.nguyentheluc_21046661_week05.ids.CandidateSkillId;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.CandidateSkill;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    List<CandidateSkill> findBySkillId(Long skillId);

    List<CandidateSkill> findByCandidateId(Long candidateId);
}
