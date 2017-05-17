package fang.service;


import fang.bean.ShoppingCar;

/**
 * Created by liutim on 2016/10/23.
 */
public interface IShoppingCarService {
    /**
     * 获取当前用户购物车
     * @param customerid
     * @return
     */
    ShoppingCar getShoppingCar(String customerid, boolean refresh);

    /**
     * 删除当前用户购物车中的商品，根据商品id数组
     * @param customerid
     * @param productid
     * @return
     */
    ShoppingCar deleteItemsByProductIds(String customerid, String[] productid);

    /**
     * 添加产品到购物车
     * @param productid
     * @param customerid
     * @return
     */
    ShoppingCar addItemsByProductId(String productid, String customerid);
}
