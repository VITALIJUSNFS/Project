package task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long carId;
    private String brand;
    private String color;

}
