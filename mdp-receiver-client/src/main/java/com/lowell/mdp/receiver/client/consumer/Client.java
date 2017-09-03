package com.lowell.mdp.receiver.client.consumer;

import com.lowell.mdp.receiver.facade.stub.MsgSenderInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.alibaba.dubbo.config.annotation.Reference;


/**
 * Created by Lowell on 17-7-5.
 */
@RestController
public class Client {
	
	private static final Logger log = LoggerFactory.getLogger(Client.class);

	/**
	 * dubbo注解，远程调用分布
	 */
    @Reference
    private MsgSenderInterface msgSenderInterface;
    
    /**
     * http://localhost:8082/test
     * mainInterfaceTest2
     * @return 
     * Integer
     * @exception 
     * @since  1.0.0
     */
    @RequestMapping(value = { "/sendMsgToMQTest" }, method = RequestMethod.GET)
    @ResponseBody
    public boolean  mainInterfaceTest2(@RequestParam(value ="paras") String paras){
        log.info("paras:", paras);
        boolean result = msgSenderInterface.sendMsgToMQ(paras);
        log.info("result:", result);
        return result;
    }
    
}
