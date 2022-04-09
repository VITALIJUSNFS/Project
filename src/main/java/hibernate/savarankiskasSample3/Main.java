package hibernate.savarankiskasSample3;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

         Session session = HibernateUtil.getSessionFactory().openSession();

        Passport mikePassport = Passport.builder()
                .passportNumber("A5464a")
                .passportId(null)
                .nationality("American")
                .build();

        Traveler mike = Traveler.builder()
                .travelerId(null)
                .email("asd@gmail.com")
                .firstName("Mike")
                .lastName("Sulivan")
                .passport(mikePassport)
                .build();

        //Reiketu iskelti i TravelerRepositori, kad maino nebutu

        session.beginTransaction();
        session.save(mike);
        session.getTransaction().commit();

        session.beginTransaction();
        session.delete(mike);
        session.getTransaction().commit();


    }
}
