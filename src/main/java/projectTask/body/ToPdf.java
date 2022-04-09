package projectTask.body;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;

public class ToPdf {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projDarbas?serverTimezone=UTC";

    @SneakyThrows
    public static void convertingToPdf() {

        OutputStream file = null;
        try {
            file = new FileOutputStream(new File("Contacts.pdf"));

            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from customer;");

            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK.brighter());
            Font font1 = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.RED);

            // Writing content
            document.add(new Paragraph("Company name", font));
            document.add(new Paragraph("Documentation for customers: ", font1));
            document.add(new Paragraph(new Date(new java.util.Date().getTime()).toString()));
            document.add(new Paragraph("          ", font1));

            PdfPTable my_first_table = new PdfPTable(3);
            PdfPCell table_cell;

            while (result.next()) {

                String name = result.getString("name");
                table_cell = new PdfPCell(new Phrase(name));
                my_first_table.addCell(table_cell);
                String phoneNumber = result.getString("phoneNumber");
                table_cell = new PdfPCell(new Phrase(phoneNumber));
                my_first_table.addCell(table_cell);
                String customerType = result.getString("customerType");
                table_cell = new PdfPCell(new Phrase(customerType));
                my_first_table.addCell(table_cell);
//                int customerId = result.getInt("customerId");
//                table_cell = new PdfPCell(new Phrase(customerId));
//                my_first_table.addCell(table_cell);

                document.add(my_first_table);


                document.close();
                System.out.println("Your PDF File is succesfully created");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}