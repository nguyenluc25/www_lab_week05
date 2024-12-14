package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", length = 20)
    private long id;

    @Column(name = "phone", length = 15, unique = true)
    private String phone;

    private LocalDate dob;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "full_name", length = 255)
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "candidate")
    @ToString.Exclude
    private List<CandidateSkill> candidateSkills;

    @OneToMany(mappedBy = "candidate")
    @ToString.Exclude
    private List<Experience> experiences;

    @OneToOne
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;
}
