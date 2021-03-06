package detailingProject.body.bDataRelated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;

    private String regNr;
    private String brand;
    private String carType;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}