package fang.service;

import fang.bean.Goods;
import fang.repository.GoodsDao;
import fang.repository.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by asus on 2016/11/15.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private QueryDao queryDao;

    public void add(Goods goods){
        this.goodsDao.save(goods);
    }

    public void delete(String id){
        this.goodsDao.delete(id);
    }

    public Object findOne(String id){
        return this.goodsDao.findOne(id);
    }

    /**
     *前端搜索引擎
     */

    private String goodsfindSql(String maintitle,String classification){
        String sql;
        if(!classification.equals("空")){
            sql="SELECT\n" +
                    "  g.*\n" +
                    "FROM goods g \n" +
                    "WHERE g.classification LIKE '%"+classification+"%'";
        }else {
            sql="SELECT\n" +
                    "  g.*\n" +
                    "FROM goods g \n" +
                    "WHERE g.maintitle LIKE '%"+maintitle+"%' ";
        }
        return sql;
    }

    public Page<Map<String,Object>> goodsfindsearch(String maintitle,String classification,int pages, int row, String order, String sort) {
        Sort s=order.equals("asc")?new Sort(Sort.Direction.ASC, sort):new Sort(Sort.Direction.DESC, sort);
            Page<Map<String,Object>> page=this.queryDao.query(goodsfindSql(maintitle,classification),new PageRequest(pages-1  ,row,s));
        return page;
    }
}
