package hibernate.example2OneToOne;

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

public class Employee {

    @Id // pirminis raktas
    @GeneratedValue (strategy = GenerationType.IDENTITY)// autoincrementas
    private Integer employeeId;

    private String email;
    private String firstName;
    private String lastName;

    //sukurti sarisi one to one
    @OneToOne(cascade = CascadeType.ALL) // saugant i DB employee bus automatiskai issaugotas account //skirtas susijusiam tarpusavi sarysi operuoti
    @JoinColumn(name = "accountId")// cia nuorodom FK emploee lenteleja, tam kad butu sarysis su account
    private Account account; // kompozicija

}
