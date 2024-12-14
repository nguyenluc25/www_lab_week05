package vn.edu.iuh.nguyentheluc_21046661_week05.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.nguyentheluc_21046661_week05.models.Account;

import java.util.Optional;

@Repository

public interface AccountRepository  extends JpaRepository<Account, Long> {
    Optional<Account> findByUsernameAndPassword(String username, String password);
}
