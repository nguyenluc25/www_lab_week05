package vn.edu.iuh.nguyentheluc_21046661_week05.controllers;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.nguyentheluc_21046661_week05.dtos.JobDTO;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Account;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Candidate;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Job;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Skill;
import vn.edu.iuh.nguyentheluc_21046661_week05.services.CompanyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/company")
    public String company( Model model, HttpSession session) {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        if(session.getAttribute("accountType").equals("CANDIDATE")) {
            return "redirect:/";
        }

        Account account = (Account) session.getAttribute("account");
        List<Job> jobs = companyService.getJobsByCompanyId( account.getId(), session);
        model.addAttribute("jobs", jobs);
        return "company/index";
    }

    @GetMapping("/company/create-job")
    public String createJob(Model model, HttpSession session) {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        if(session.getAttribute("accountType").equals("CANDIDATE")) {
            return "redirect:/";
        }

        List<Skill> skills = companyService.getAllSkills();
        model.addAttribute("skills", skills);
        return "company/job-posting";
    }

    @PostMapping("/company/create-job")
    public String createJob(@ModelAttribute JobDTO jobDTO, HttpSession session) {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        if(session.getAttribute("accountType").equals("CANDIDATE")) {
            return "redirect:/";
        }

        companyService.createJob(jobDTO, session);
        return "redirect:/company";
    }

    @GetMapping("/company/suitable-candidate/{jobId}")
    public String suitableCandidate(@PathVariable("jobId") Long jobId, Model model, HttpSession session) {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        if(session.getAttribute("accountType").equals("CANDIDATE")) {
            return "redirect:/";
        }

        List<Candidate> candidates = companyService.getSuitableCandidates(jobId);
        model.addAttribute("candidates", candidates);
        return "company/suitable-candidate";
    }

    @PostMapping("/company/send-email/{candidateId}")
    public String sendEmail(@PathVariable("candidateId") Long candidateId, HttpSession session) throws MessagingException {
        if(session.getAttribute("account") == null) {
            return "redirect:/";
        }
        if(session.getAttribute("accountType").equals("CANDIDATE")) {
            return "redirect:/";
        }

        companyService.sendJobInvitationEmail(candidateId);
        return "redirect:/company";
    }
}
