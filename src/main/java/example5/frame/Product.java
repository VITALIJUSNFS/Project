package example5.frame;

public class Product {

    private int productId;
    private String productName;
    private int productPrice;
    private Dealer dealer;

    public Product(int productId, String productName, int productPrice, Dealer dealer) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.dealer = dealer;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", dealer=" + dealer +
                '}';
    }
}
