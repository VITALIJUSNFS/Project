package hibernate.example2OneToOne;

import org.hibernate.Session;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Account astAccountas = Account.builder()
                .accountNumber("123456")
                .employmentDate(LocalDate.of(2022,3,8))
                .build();

        // System.out.println(account);

        Employee ast = Employee.builder()
                .email("ast@gmail.com")
                .firstName("Ast")
                .lastName("Estusmas")
                .account(astAccountas)
                .build();
        //System.out.println(ast);

        //Reiketu iskelti i EmployeeRepositori, kad maino nebutu

        session.beginTransaction();
        session.save(ast);
        session.getTransaction().commit();

        session.beginTransaction();
        session.delete(ast);
        session.getTransaction().commit();

    }
}
