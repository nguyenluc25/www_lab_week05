package vn.edu.iuh.nguyentheluc_21046661_week05.services;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.nguyentheluc_21046661_week05.dtos.JobResponseDTO;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.*;
import vn.edu.iuh.nguyentheluc_21046661_week05.repositories.CandidateRepository;
import vn.edu.iuh.nguyentheluc_21046661_week05.repositories.CandidateSkillRepository;
import vn.edu.iuh.nguyentheluc_21046661_week05.repositories.JobSkillRepository;
import vn.edu.iuh.nguyentheluc_21046661_week05.repositories.SkillRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateSkillRepository candidateSkillRepository;
    private final JobSkillRepository jobSkillRepository;
    private final SkillRepository skillRepository;

    public String getAllSkills(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        Candidate candidate = candidateRepository.findByAccountId(account.getId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        List<CandidateSkill> candidateSkills = candidateSkillRepository.findByCandidateId(candidate.getId());
        List<String> skillNames = candidateSkills.stream()
                .map(candidateSkill -> candidateSkill.getSkill() != null ? candidateSkill.getSkill().getSkillName() : "")
                .collect(Collectors.toList());

        return String.join(", ", skillNames);
    }


    public Candidate getCandidateByAccountId(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        return candidateRepository.findByAccountId(account.getId()).orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public List<JobResponseDTO> getSuitableJobs(HttpSession session) {
        Map<Long, JobResponseDTO> jobResponseMap = new HashMap<>();  // Map để lưu công việc theo ID

        Account account = (Account) session.getAttribute("account");
        Candidate candidate = candidateRepository.findByAccountId(account.getId()).orElseThrow(() -> new RuntimeException("Candidate not found"));
        List<CandidateSkill> candidateSkills = candidateSkillRepository.findByCandidateId(candidate.getId());

        for (CandidateSkill candidateSkill : candidateSkills) {
            List<JobSkill> jobSkills = jobSkillRepository.findBySkillId(candidateSkill.getSkill().getId());
            for (JobSkill jobSkill : jobSkills) {
                Job job = jobSkill.getJob();
                List<String> skills = jobSkillRepository.findByJobId(job.getId()).stream().map(JobSkill::getSkill).map(Skill::getSkillName).toList();
                List<String> skillToLearn = getSuggestedSkillsByJobId(job.getId(), session).stream().map(Skill::getSkillName).toList();

                JobResponseDTO existingJobResponse = jobResponseMap.get(job.getId());
                if (existingJobResponse == null) {
                    JobResponseDTO jobResponseDTO = JobResponseDTO.builder()
                            .job(job)
                            .skills(String.join(", ", skills))
                            .skillToLearn(String.join(", ", skillToLearn))
                            .build();
                    jobResponseMap.put(job.getId(), jobResponseDTO);
                }
            }
        }

        return new ArrayList<>(jobResponseMap.values());
    }


    public List<Skill> getSuggestedSkillsByJobId(long jobId, HttpSession session) {
        List<Skill> skills = new ArrayList<>();

        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            throw new RuntimeException("Account not found in session");
        }

        Candidate candidate = candidateRepository.findByAccountId(account.getId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        List<CandidateSkill> candidateSkills = candidateSkillRepository.findByCandidateId(candidate.getId());
        List<Skill> candidateSkillList = candidateSkills.stream()
                .map(CandidateSkill::getSkill)
                .filter(Objects::nonNull)
                .toList();

        List<JobSkill> jobSkills = jobSkillRepository.findByJobId(jobId);
        List<Skill> jobSkillList = jobSkills.stream()
                .map(JobSkill::getSkill)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());


        jobSkillList.removeAll(candidateSkillList);
        skills.addAll(jobSkillList);

        return skills;
    }

}
