package hibernate.example5ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer bookId;

    private String title;
    private Integer price;

    @ManyToOne
    @JoinColumn (name = "ownerId")
    private Owner owner;



}
