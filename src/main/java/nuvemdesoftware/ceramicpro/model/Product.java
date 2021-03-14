package nuvemdesoftware.ceramicpro.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   seq_id;

    @Column(nullable = false)
    private String  customer_product_id;
    @Column(nullable = false)
    private String  product_name;
    @Column(nullable = false)
    private String  internal_product_id;
    @Column(nullable = true)
    private String  client_name;
    @Column(nullable = true)
    private String  product_name_for_label;
    @Column(nullable = true, columnDefinition = "INT default 0")
    private int     num_articles_in_box;
    @Column(nullable = true, columnDefinition = "INT default 0")
    private int     family;
    @Column(nullable = true, columnDefinition = "DECIMAL(7,2) default '0.0'")
    private double  price_euro_1;
    @Column(nullable = true, columnDefinition = "DECIMAL(7,2) default '0.0'")
    private double  price_euro_2;
    @Column(nullable = true)
    private String  image_path;
    @Column(nullable = true)
    private String  image_name;
    @Column(nullable = true, columnDefinition = "BIGINT default 0")
    private long    bar_code_number;
    @Column(nullable = true)
    private String  article_zpl_string;
    @Column(nullable = true)
    private String  box_zpl_string;
    @Column(nullable = true, columnDefinition = "boolean default false")
    private boolean is_parent;
    @Column(nullable = true)
    private String  parent_customer_product_id;

    public Product() {
    }

    public Product(Product product) {
    }

    public long getSeq_id() {
        return seq_id;
    }

    public void setSeq_id(long seq_id) {
        this.seq_id = seq_id;
    }

    public String getCustomer_product_id() {
        return customer_product_id;
    }

    public void setCustomer_product_id(String customer_product_id) {
        this.customer_product_id = customer_product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getInternal_product_id() {
        return internal_product_id;
    }

    public void setInternal_product_id(String internal_product_id) {
        this.internal_product_id = internal_product_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getProduct_name_for_label() {
        return product_name_for_label;
    }

    public void setProduct_name_for_label(String product_name_for_label) {
        this.product_name_for_label = product_name_for_label;
    }

    public int getNum_articles_in_box() {
        return num_articles_in_box;
    }

    public void setNum_articles_in_box(int num_articles_in_box) {
        this.num_articles_in_box = num_articles_in_box;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public double getPrice_euro_1() {
        return price_euro_1;
    }

    public void setPrice_euro_1(double price_euro_1) {
        this.price_euro_1 = price_euro_1;
    }

    public double getPrice_euro_2() {
        return price_euro_2;
    }

    public void setPrice_euro_2(double price_euro_2) {
        this.price_euro_2 = price_euro_2;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public long getBar_code_number() {
        return bar_code_number;
    }

    public void setBar_code_number(long bar_code_number) {
        this.bar_code_number = bar_code_number;
    }

    public String getArticle_zpl_string() {
        return article_zpl_string;
    }

    public void setArticle_zpl_string(String article_zpl_string) {
        this.article_zpl_string = article_zpl_string;
    }

    public String getBox_zpl_string() {
        return box_zpl_string;
    }

    public void setBox_zpl_string(String box_zpl_string) {
        this.box_zpl_string = box_zpl_string;
    }

    public boolean isIs_parent() {
        return is_parent;
    }

    public void setIs_parent(boolean is_parent) {
        this.is_parent = is_parent;
    }

    public String getParent_customer_product_id() {
        return parent_customer_product_id;
    }

    public void setParent_customer_product_id(String parent_customer_product_id) {
        this.parent_customer_product_id = parent_customer_product_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "customer_product_id='" + customer_product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", internal_product_id='" + internal_product_id + '\'' +
                ", client_name='" + client_name + '\'' +
                ", product_name_for_label='" + product_name_for_label + '\'' +
                ", num_articles_in_box=" + num_articles_in_box +
                ", family=" + family +
                ", price_euro_1=" + price_euro_1 +
                ", price_euro_2=" + price_euro_2 +
                ", image_path='" + image_path + '\'' +
                ", image_name='" + image_name + '\'' +
                ", bar_code_number=" + bar_code_number +
                ", article_zpl_string='" + article_zpl_string + '\'' +
                ", box_zpl_string='" + box_zpl_string + '\'' +
                ", is_parent=" + is_parent +
                ", parent_customer_product_id='" + parent_customer_product_id + '\'' +
                '}';
    }
}
