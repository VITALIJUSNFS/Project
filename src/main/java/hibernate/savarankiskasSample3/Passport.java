package hibernate.savarankiskasSample3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer passportId;
    private String nationality;
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Traveler traveler;
}
