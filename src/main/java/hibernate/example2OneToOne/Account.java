package hibernate.example2OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer accountId;

    private String accountNumber;
    private LocalDate employmentDate;

    //turi rodyti i Employee klases account fielda
    @OneToOne(mappedBy = "account")
    private Employee employee;

}
