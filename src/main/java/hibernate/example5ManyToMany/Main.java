package hibernate.example5ManyToMany;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Owner tomas = Owner.builder().name("Tomas").email("@tomas.lt").country("LT").build();
        Book tvAntena = Book.builder().title("TV antena").price(15).owner(tomas).build();

        List<Book> books = new ArrayList<>();
        books.add(tvAntena);

        tomas.setBooks(books);

        session.beginTransaction();
        session.save(tomas);
        session.getTransaction().commit();

        Library mazvydoBiblioteka = Library.builder()
                .address("Adresas")
                .name("Mazvydo")
                .owners(Set.of(tomas)).build();

        Library zverynoBiblioteka = Library.builder()
                .address("Adresas1")
                .name("Zveryno")
                .owners(Set.of(tomas)).build();

        session.beginTransaction();
        session.persist(mazvydoBiblioteka);
        session.persist(zverynoBiblioteka);
        session.getTransaction().commit();


        session.beginTransaction();
        session.delete(mazvydoBiblioteka);
//        session.delete(zverynoBiblioteka);
        session.getTransaction().commit();

    }
}
