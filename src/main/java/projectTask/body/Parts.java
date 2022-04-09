package projectTask.body;

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

public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partId;

    private String partName;
    private String partNumber;
    private int price;
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
