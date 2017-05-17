package fang.bean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by asus on 2016/9/19.
 */
@Entity
@Table(name = "qi_shoppingcaritem")
public class ShoppingCarItem{

    @Id
    @NotNull
    private String id;

    private String productid;
    private int price;
    private String url;
    private int number=0;
    private int finalprice;
    private String name;


    @JsonIgnore
    @JoinColumn(name="shopping_id")
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public ShoppingCar shoppingCar;

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(ShoppingCar shoppingCar) {
        this.shoppingCar = shoppingCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(int finalprice) {
        this.finalprice = finalprice;
    }

}
