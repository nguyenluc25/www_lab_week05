package vn.edu.iuh.nguyentheluc_21046661_week05.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 6)
    private CountryCode country;

    @Column(name = "street", length = 150)
    private String street;

    @Column(name = "zipcode", length = 7)
    private String zipCode;

    @Column(name = "number", length = 20)
    private String number;

    @OneToOne(mappedBy = "address")
    @ToString.Exclude
    private Candidate candidate;

    @OneToOne(mappedBy = "address")
    @ToString.Exclude
    private Company company;
}
