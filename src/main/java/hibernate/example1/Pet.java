package hibernate.example1;

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

public class Pet {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long petId;

    private String name;
    private int age;

}
