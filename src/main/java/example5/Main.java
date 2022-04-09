package example5;

import example5.frame.Dealer;
import example5.frame.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String DATABASE_USER = "root"; //mano db user
    private static final String DATABASE_PASSWORD = "admin"; // mano db psw
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun2?serverTimezone=UTC";

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product inner join dealer on product.dealer_id = dealer.dealer_id;");

            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productMame = resultSet.getString("product_name");
                int productPrice = resultSet.getInt("product_price");
                String dealerName = resultSet.getString("dealer_name");
                int dealerId =  resultSet.getInt("dealer_id");

                Dealer dealer = new Dealer();
                dealer.setDealerId(dealerId);
                dealer.setDealerName(dealerName);

                Product product = new Product();
                product.setProductId(productId);
                product.setProductPrice(productPrice);
                product.setProductName(productMame);
                product.setDealer(dealer);

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Product product : products) {
            System.out.println(products);
        }
    }
}
