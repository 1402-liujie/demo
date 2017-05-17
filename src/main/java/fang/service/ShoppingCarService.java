package fang.service;

import fang.bean.ShoppingCar;
import fang.bean.ShoppingCarItem;
import fang.repository.GoodsDao;
import fang.repository.ShoppingCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by asus on 2016/9/19.
 */
@Service
@Transactional
public class ShoppingCarService implements IShoppingCarService {
    @Autowired
    private ShoppingCarRepository shoppingCarRepository;

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 获取该用户的购物车,如果为空呢，则新增一个空购物车
     * @param customerid
     * @return 一定会拿到该用户的购物车
     */
    @Override
    public synchronized ShoppingCar getShoppingCar(String customerid, boolean refresh){
        ShoppingCar sc= this.shoppingCarRepository.findByCustomerid(customerid);
        if(sc==null){
            sc=new ShoppingCar();
            sc.setCustomerid(customerid);
            sc.setId(UUID.randomUUID().toString());
        }
        sc= this.shoppingCarRepository.save(sc);
        return sc;
    }

    @Override
    public synchronized  ShoppingCar deleteItemsByProductIds(String customerid, String[] productid){
        ShoppingCar shoppingCar=this.getShoppingCar(customerid,false);
        shoppingCar.removeItems(productid);
        return this.shoppingCarRepository.save(shoppingCar);
    }

    @Override
    public synchronized ShoppingCar addItemsByProductId(String productid, String customerid) {
        ShoppingCar sc=this.getShoppingCar(customerid,false);
        ShoppingCarItem sci = sc.contain(productid);
        if (sci == null) {
            sc.getShoppingcarItems().add(this.goodsDao.findOne(productid).convertTo(sc));
        } else {
            sci.setNumber(sci.getNumber() + 1);
        }
        return this.shoppingCarRepository.save(sc);
    }
}
