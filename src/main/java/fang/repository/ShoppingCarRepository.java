package fang.repository;

import fang.bean.ShoppingCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by asus on 2016/9/19.
 */
@Repository
public interface ShoppingCarRepository extends CrudRepository<ShoppingCar, String> {
     ShoppingCar findByCustomerid(String customerid);
}
