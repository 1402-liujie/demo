package fang.control;

import fang.page.PageUtil;
import fang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fang.service.IShoppingCarService;

/**
 * Created by asus on 2017/3/15.
 */

@RestController
@CrossOrigin(origins = {}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class MianController extends BaseController{

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private IShoppingCarService IShoppingCarService;

    /**
     * 商品
     * @param id
     * @return
     */

    @RequestMapping("/goods/findOne")
    Object goodsfindOne(String id) {
        return this.goodsService.findOne(id);
    }

    @RequestMapping("/getUser")
    Object goods() {
        return this.getClientid();
    }

    @RequestMapping("/goods/find/search")
    Object goodsfindSearch(
            @RequestParam(required = false, defaultValue = "")
            String maintitle,
            String classification,
            int pages,
            int row,
            @RequestParam(required = false, defaultValue = "desc")
            String order,
            @RequestParam(required = false, defaultValue = "g.price")
            String sort) {
        return PageUtil.convert(this.goodsService.goodsfindsearch(maintitle,classification,pages, row, order, sort));
    }

    /**
     * 购物车
     * @param refresh
     * @return
     */

    @RequestMapping("/shoppingcar/find")
    public Object shoppingCarfind(boolean refresh){
        return this.IShoppingCarService.getShoppingCar(this.getClientid(),refresh);
    }

    @RequestMapping("/shoppingcar/increase")
    @ResponseBody
    public Object shoppingcaradd(String productid) {
        this.IShoppingCarService.addItemsByProductId(productid,this.getClientid());
        return true;
    }
    @RequestMapping("/shoppingcar/delete")
    @ResponseBody
    public Object shoppingcardelete(String[] productid){
        if(productid==null){
            return false;
        }else {
            this.IShoppingCarService.deleteItemsByProductIds(this.getClientid(),productid);
            return true;
        }
    }

}
