package fang.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by asus on 2016/9/19.
 */
@Entity
@Table(name = "qi_shoppingcar")
public class ShoppingCar{

    @Id
    @NotNull
    private String id;

    private String customerid;

    @OneToMany(orphanRemoval=true,fetch= FetchType.EAGER,mappedBy="shoppingCar",cascade= CascadeType.ALL)
    private List<ShoppingCarItem> shoppingcarItems=new ArrayList<>();

    public List<ShoppingCarItem> getShoppingcarItems() {
        return shoppingcarItems;
    }

    public void setShoppingcarItems(List<ShoppingCarItem> shoppingcarItems) {
        this.shoppingcarItems = shoppingcarItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }



    /**
     * 查找是否存在含有productid的条目，如果不存在返null
     * @param productid
     * @return
     */
    public ShoppingCarItem contain(String productid){
            for(ShoppingCarItem sci: this.getShoppingcarItems()){
                if(productid.equals(sci.getProductid())){
                    return sci;
                }
            }
        return null;
    }

    /**
     * 删除购物车中的多个商品条目
     * @param
     */

    public void removeItems(String[] productids) {
        Iterator<ShoppingCarItem> ite=this.getShoppingcarItems().iterator();
        while(ite.hasNext()){
            ShoppingCarItem item=ite.next();
            for(int i=0;i<productids.length;i++){
                if(item.getProductid().equals(productids[i])){
                    ite.remove();
                }
            }
        }
    }

    public void removeitemone(String productid) {
        Iterator<ShoppingCarItem> ite=this.getShoppingcarItems().iterator();
        while(ite.hasNext()){
            ShoppingCarItem item=ite.next();
            if(item.getProductid().equals(productid)){
                ite.remove();
            }
        }
    }
}
