package vn.edu.iuh.nguyentheluc_21046661_week05.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.AccountType;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Account;
import vn.edu.iuh.nguyentheluc_21046661_week05.services.AccountService;

import javax.security.sasl.AuthenticationException;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/")
    public String index(HttpSession session) {
        if(session.getAttribute("account") != null) {
            Account account = (Account) session.getAttribute("account");
            String accountType = account.getAccountType().name();
            return accountType.equals(AccountType.CANDIDATE.name()) ? "redirect:/candidate" : "redirect:/company";
        }
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        try {
            Account account = accountService.login(username, password);
            String accountType = account.getAccountType().name();

            session.setAttribute("accountType", accountType);
            session.setAttribute("account", account);

            return accountType.equals(AccountType.CANDIDATE.name()) ? "redirect:/candidate" : "redirect:/company";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid email or password");
            return "index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("account");
        session.removeAttribute("accountType");
        return "redirect:/";
    }
}
