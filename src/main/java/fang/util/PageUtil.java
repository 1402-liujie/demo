package fang.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2016/10/12.
 */
public class PageUtil {

    public static Map convertPage(Page page){
        Map map = new HashMap();
        map.put("total", page.getTotalElements());//数据总数
        map.put("rows",page.getContent());//分页应该显示的数据
        return map;
    }

    public static Map convert(Page<Map<String,Object>> page){
        Map<String,Object> map=new HashMap();
        map.put("total",page.getTotalElements());
        map.put("rows",page.getContent());
        return map;
    }
}
