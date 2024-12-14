package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", length = 20)
    private long id;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "company_name", length = 120)
    private String companyName;

    @Column(name = "role", length = 100)
    private String role;

    @Column(name = "work_desc", length = 400)
    private String workDescription;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
