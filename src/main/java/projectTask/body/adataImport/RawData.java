package projectTask.body.adataImport;

import org.hibernate.Session;

import projectTask.body.bDataRelated.*;
import projectTask.body.cservices.HibernateUtil;


import java.sql.SQLException;

public class RawData {

    public static void addRawData() throws SQLException {
        Session session = HibernateUtil.getSessionFactoryCreate(null).openSession();

        Customer tomas = Customer.builder().name("Tomas").phoneNumber("+370********").customerType("Client").customerId(1).build();
        Vehicle audi = Vehicle.builder().regNr("PVC248").brand("Audi A6").customer(tomas).build();
        Parts used = Parts.builder().partName("Hose").partNumber("20545245").customer(tomas).quantity(2).build();
        Orders order = Orders.builder().description("Detailing").orderDate("2021-02-21").customer(tomas).build();
        Offers offer = Offers.builder().name("mini").price(35).customer(tomas).build();

        session.beginTransaction();
        session.save(tomas);
        session.save(audi);
        session.save(used);
        session.save(order);
        session.save(offer);
        session.getTransaction().commit();

        Customer samas = Customer.builder().name("Samas").phoneNumber("+3706546565").customerType("Client").customerId(2).build();
        Vehicle audi249 = Vehicle.builder().regNr("PVC249").brand("Audi A8").customer(samas).build();
        Parts used2 = Parts.builder().partName("Tube").partNumber("20545245").customer(samas).price(10).quantity(1).build();
        Orders order2 = Orders.builder().description("Detailing").orderDate("2022-02-21").customer(samas).build();
        Offers offer2 = Offers.builder().name("max").price(115).customer(samas).build();

        session.beginTransaction();
        session.save(samas);
        session.save(audi249);
        session.save(used2);
        session.save(order2);
        session.save(offer2);
        session.getTransaction().commit();
    }
}