package fang.control;

import fang.bean.ClientInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by asus on 2016/12/21.
 */
public class BaseController {
    private static String CONST_CLIENTID ="clientid";

    private HttpSession getCurrentSession(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session=attr.getRequest().getSession(true);// true == allow create
        return session;
    }

    protected String getClientid(){
        return (String)this.getCurrentSession().getAttribute(CONST_CLIENTID);
    }

    protected void loginClient(ClientInfo client) {
        this.getCurrentSession().setAttribute(BaseController.CONST_CLIENTID,client.getClientid());
    }

}
