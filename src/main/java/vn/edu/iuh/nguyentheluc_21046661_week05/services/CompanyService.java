package vn.edu.iuh.nguyentheluc_21046661_week05.services;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.nguyentheluc_21046661_week05.dtos.JobDTO;
import vn.edu.iuh.nguyentheluc_21046661_week05.dtos.JobSkillDTO;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.SkillLevel;
import vn.edu.iuh.nguyentheluc_21046661_week05.ids.JobSkillId;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.*;
import vn.edu.iuh.nguyentheluc_21046661_week05.repositories.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final SkillRepository skillRepository;
    private final JobRepository jobRepository;
    private final JobSkillRepository jobSkillRepository;
    private final CandidateSkillRepository candidateSkillRepository;
    private final CandidateRepository candidateRepository;

    private final EmailService emailService;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getJobsByCompanyId(long accountId, HttpSession session) {
        Company company = companyRepository.findByAccountId(accountId).orElseThrow(() -> new RuntimeException("Company not found"));
        return jobRepository.findByCompanyId(company.getId());
    }

    public JobDTO createJob(JobDTO jobDTO, HttpSession session) {

        Account account = (Account) session.getAttribute("account");

        Job job = Job.builder()
                .name(jobDTO.getName())
                .description(jobDTO.getDescription())
                .company(companyRepository.findByAccountId(account.getId()).orElseThrow(() -> new RuntimeException("Company not found")))
                .build();
        jobRepository.save(job);
        List<JobSkill> jobSkills = jobDTO.getJobSkills().stream()
                .filter(jk -> jk.getSkillId() != null)
                .map(jk -> JobSkill.builder()
                        .id(JobSkillId.builder()
                                .jobId(job.getId())
                                .skillId(jk.getSkillId())
                                .build())
                        .job(job)
                        .skill(skillRepository.findById(jk.getSkillId()).orElseThrow(() -> new RuntimeException("Skill not found")))
                        .moreInfo(jk.getMoreInfor())
                        .skillLevel(SkillLevel.valueOf(jk.getSkillLevel()))
                        .build())
                .toList();
        jobSkillRepository.saveAll(jobSkills);
        return jobDTO;
    }

    public List<Candidate> getSuitableCandidates(long jobId) {
        Set<Candidate> candidatesSet = new HashSet<>(); // Sử dụng HashSet để loại bỏ duplicate
        List<JobSkill> jobSkills = jobSkillRepository.findByJobId(jobId);

        for (JobSkill jobSkill : jobSkills) {
            List<CandidateSkill> candidateSkills = candidateSkillRepository.findBySkillId(jobSkill.getId().getSkillId());
            for (CandidateSkill candidateSkill : candidateSkills) {
                candidatesSet.add(candidateSkill.getCandidate());
            }
        }
        return new ArrayList<>(candidatesSet);
    }

    public void sendJobInvitationEmail(Long candidateId) throws MessagingException {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        String subject = "Job Invitation ";
        String body = "Dear " + candidate.getFullName() + ",\n\n" +
                "We have found a job that matches your skills. Please apply for the position if you're interested.";
        emailService.sendEmail(candidate.getEmail(), subject, body);
    }
}
