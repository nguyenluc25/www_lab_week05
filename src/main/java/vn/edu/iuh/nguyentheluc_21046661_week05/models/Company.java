package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long id;

    @Column(name = "comp_name", length = 255)
    private String name;

    @Column(name = "about", length = 2000)
    private String about;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "web_url", length = 255)
    private String webURL;

    @Column(name = "email", length = 255)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    @ToString.Exclude
    private Address address;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<Job> jobs;

    @OneToOne
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;
}
