package nuvemdesoftware.ceramicpro.model;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   seq_id;

    @Column(name = "product_id", nullable = false)
    private String  productId;
    @Column(name = "product_name", nullable = false)
    private String  productName;
    @Column(name = "quantity_in_stock", nullable = false)
    private String  quantityInStock;
    @Column(nullable = true)
    private String  bar_code_number;
    @Column(nullable = true)
    private String  quantity_unit;

    public long getSeq_id() {
        return seq_id;
    }

    public void setSeq_id(long seq_id) {
        this.seq_id = seq_id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getBar_code_number() {
        return bar_code_number;
    }

    public void setBar_code_number(String bar_code_number) {
        this.bar_code_number = bar_code_number;
    }

    public String getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(String quantity_unit) {
        this.quantity_unit = quantity_unit;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "seq_id=" + seq_id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantityInStock='" + quantityInStock + '\'' +
                ", bar_code_number='" + bar_code_number + '\'' +
                ", quantity_unit='" + quantity_unit + '\'' +
                '}';
    }
}