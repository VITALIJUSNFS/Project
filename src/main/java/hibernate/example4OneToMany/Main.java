package hibernate.example4OneToMany;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Owner tomas = Owner.builder().name("Tomas").email("tomas@gmail.com").country("LT").build();
        Book cookingBook = Book.builder().title("Cooking").price(15).owner(tomas).build();
        Book songBook = Book.builder().title("Singing Tutorial").price(10).owner(tomas).build();
        List<Book> tomoKnygos = new ArrayList<>();
        tomoKnygos.add(cookingBook);
        tomoKnygos.add(songBook);
        //tomas.setBooks(tomoKnygos);
        session.beginTransaction();
        session.save(tomas);
        session.getTransaction().commit();
    }
}
