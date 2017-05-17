package fang.bean.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by liutim on 2016/10/4.
 */
@JsonSerialize(using = ErrorCodeSerializer.class)
public enum ErrorCode {
     FAIL(5555,"操作失败")
    ,USERREPPAT(4444,"用户不存在")
    ,CLIENTNOT(4444,"用户名已经注册")
    ,SUCCESS(0,"操作成功");



    public int getErrorcode() {
        return errorcode;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    private int errorcode;
    private String errorinfo;

    private ErrorCode(int errorcode,String errorinfo){
        this.errorcode=errorcode;
        this.errorinfo=errorinfo;
    }

    public String toString(){
        return "{\"errorcode\":"+this.errorcode+",\"errorinfo\":\""+this.errorinfo+"\"}";
    }

}
