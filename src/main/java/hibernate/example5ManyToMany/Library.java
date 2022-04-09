package hibernate.example5ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor // privalomas kad butu hibernete
@Builder

public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryId;

    private String name;
    private String address;

//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "owners_libraries") // sukurti tarpine lentele
    private Set<Owner> owners; // vienoje bibliotekoje gali lankytis daug owneriu

}
