package fang.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by asus on 2016/11/15.
 */
@Entity
@Table(name="goods")
public class Goods{

    @Id
    @NotNull
    private String id;

    private String maintitle;//主标题
    private String subtitle;//副标题
    private int price;
    private int soldcount=0;//已售数量
    private int remaincount=0;//剩余库存数量
    @Column(columnDefinition="TEXT")
    private String picurl;//图片url
    @Column(columnDefinition="TEXT")
    private String description;//描述
    private String classification;//分类

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classificationid) {
        this.classification = classificationid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaintitle() {
        return maintitle;
    }

    public void setMaintitle(String maintitle) {
        this.maintitle = maintitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoldcount() {
        return soldcount;
    }

    public void setSoldcount(int soldcount) {
        this.soldcount = soldcount;
    }

    public int getRemaincount() {
        return remaincount;
    }

    public void setRemaincount(int remaincount) {
        this.remaincount = remaincount;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * 转换成某个用户的购物车条目
     * @return
     */
    public ShoppingCarItem convertTo(ShoppingCar shoppingCar){
        ShoppingCarItem shoppingCarItem = new ShoppingCarItem();
        shoppingCarItem.setId(UUID.randomUUID().toString());
        shoppingCarItem.setPrice(this.getPrice());
        shoppingCarItem.setUrl(this.getPicurl());
        shoppingCarItem.setFinalprice(this.getPrice());
        shoppingCarItem.setProductid(this.getId());
        shoppingCarItem.setNumber(1);
        shoppingCarItem.setName(this.getMaintitle());
        shoppingCarItem.setShoppingCar(shoppingCar);
        return shoppingCarItem;
    }

}
