package fang.repository;

/**
 * Created by Puckery on 2016.12.02.
 */

import fang.bean.ClientInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInfoRepository extends CrudRepository<ClientInfo, String>{
    ClientInfo findByClientidAndPassword(String clientid,String password);
    ClientInfo findByClientid(String clientId);
}
