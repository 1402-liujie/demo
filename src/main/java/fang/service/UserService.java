package fang.service;

import fang.bean.ClientInfo;
import fang.repository.ClientInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2016/12/21.
 */
@Service
public class UserService {
    @Autowired
    private ClientInfoRepository clientInfoRepository;

    public ClientInfo findByInfo(String name, String password){
        return clientInfoRepository.findByClientidAndPassword(name, password);
    }

    public ClientInfo addInfo(ClientInfo clientInfo){
        return this.clientInfoRepository.save(clientInfo);
    }

    public ClientInfo findInfo(String clientid){
        return this.clientInfoRepository.findByClientid(clientid);
    }

}
