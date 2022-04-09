package hibernate.example5ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;

    private String name;
    private String email;
    private String country;

    @OneToMany( mappedBy = "owner",cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToMany(mappedBy = "owners")
    private Set<Library> libraries;




}
