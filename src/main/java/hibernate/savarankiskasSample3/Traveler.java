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

public class Traveler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelerId;
    private String firstName;
    private String lastName;
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "travelerId")
    private Passport passport;

}
