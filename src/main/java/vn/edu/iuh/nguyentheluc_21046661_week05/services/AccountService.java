package vn.edu.iuh.nguyentheluc_21046661_week05.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Account;
import vn.edu.iuh.nguyentheluc_21046661_week05.repositories.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account login(String username, String password) {
        Account account = accountRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new RuntimeException("Account not found"));
        return account;
    }


}
