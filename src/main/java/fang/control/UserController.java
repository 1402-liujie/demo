package fang.control;

import fang.bean.ClientInfo;
import fang.bean.enums.ErrorCode;
import fang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by asus on 2016/12/21.
 */
@RestController
@CrossOrigin(origins = {}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @param httpSession
     * @return
     */
    @RequestMapping("/login/client")
    @ResponseBody
    public Object clientLogin(String username, @RequestParam String password, HttpSession httpSession){

        ClientInfo clientInfo=this.userService.findByInfo(username,password);
        if(clientInfo!=null){
            this.loginClient(clientInfo);
            return ErrorCode.SUCCESS;
        }else{
            return ErrorCode.FAIL;
        }
    }

    /**
     * 注册用户
     * @return
     */
    @RequestMapping("/add/client")
    @ResponseBody
    public Object clientAdd(String clientid,String password){
        ClientInfo clientInfo_old=this.userService.findInfo(clientid);
        if(clientInfo_old==null){
            ClientInfo clientInfo=new ClientInfo();
            clientInfo.setClientid(clientid);
            clientInfo.setPassword(password);
            this.userService.addInfo(clientInfo);
            return ErrorCode.SUCCESS;
        }else {
            return ErrorCode.CLIENTNOT;
        }

    }
}
