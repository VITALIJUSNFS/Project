package task;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarRepository {

    private static Session session = HibernateUtil.getSessionFactory().openSession();

//    public void save(Car car) {
//        Transaction transaction = session.beginTransaction();
//        session.persist(car); // tas pats kas INSERT INTO
//        transaction.commit();
//        System.out.println("Car was created: " + car);
//    }
//1/
    public Car findById(Long id) {
        return session.find(Car.class, id); // veikia kaip selct * from pets where petId = id
    }



    //2
    public void delete(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        System.out.println("Car was deleted: " + car);
    }

    public void deleteById(Long id) {
        Transaction transaction = session.beginTransaction();
        session.delete(findById(id));
        transaction.commit();
        System.out.println("Pet was deleted by id : " + id);
    }

}
