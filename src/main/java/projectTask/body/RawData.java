package projectTask.body;

import org.hibernate.Session;

import java.sql.SQLException;

public class RawData {

    public static void addRawData() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer tomas = Customer.builder().name("Tomas").phoneNumber("+370********").customerType("Client").customerId(1).build();
        Vehicle audi = Vehicle.builder().regNr("PVC248").brand("Audi A6").customer(tomas).build();
        Parts used = Parts.builder().partName("Hose").partNumber("20545245").customer(tomas).quantity("2").build();

        session.beginTransaction();
        session.save(tomas);
        session.save(audi);
        session.save(used);
        session.getTransaction().commit();

        //
        Customer samas = Customer.builder().name("Samas").phoneNumber("+3706546565").customerType("Client").customerId(2).build();
        Vehicle audi249 = Vehicle.builder().regNr("PVC249").brand("Audi A8").customer(samas).build();
        Parts used2 = Parts.builder().partName("Tube").partNumber("20545245").customer(samas).price(10).quantity("2").build();

        session.beginTransaction();
        session.save(samas);
        session.save(audi249);
        session.save(used2);
        session.getTransaction().commit();
    }
}