package vn.edu.iuh.nguyentheluc_21046661_week05.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.nguyentheluc_21046661_week05.dtos.JobResponseDTO;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Candidate;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Job;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.JobSkill;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Skill;
import vn.edu.iuh.nguyentheluc_21046661_week05.services.CandidateService;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping("/candidate")
    public String candidate(Model model, HttpSession session) {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        if(session.getAttribute("accountType").equals("COMPANY")) {
            return "redirect:/";
        }

        Candidate candidate = candidateService.getCandidateByAccountId(session);
        model.addAttribute("candidate", candidate);

        String skills = candidateService.getAllSkills(session);
        model.addAttribute("skills", skills);

        List<JobResponseDTO> jobResponseDTOS = candidateService.getSuitableJobs(session);
        model.addAttribute("jobResponseDTOS", jobResponseDTOS);

        return "candidate/index";
    }
}
