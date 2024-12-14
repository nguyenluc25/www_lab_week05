package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.nguyentheluc_21046661_week05.enums.AccountType;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", length = 100, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "type", length = 100)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
