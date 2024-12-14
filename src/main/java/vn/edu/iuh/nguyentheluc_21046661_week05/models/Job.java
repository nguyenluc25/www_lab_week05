package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", length = 20)
    private long id;

    @Column(name = "job_name", length = 255)
    private String name;

    @Column(name = "job_desc", length = 2000)
    private String description;

    @OneToMany(mappedBy = "job")
    @ToString.Exclude
    private List<JobSkill> jobSkills;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
