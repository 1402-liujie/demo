package fang.repository;

import fang.bean.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by asus on 2016/11/15.
 */
@Repository
public interface GoodsDao extends CrudRepository<Goods,String> {
}
