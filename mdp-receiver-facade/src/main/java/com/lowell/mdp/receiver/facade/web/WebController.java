package com.lowell.mdp.receiver.facade.web;


import com.alibaba.fastjson.JSON;
import com.lowell.mdp.receiver.facade.stub.MsgSenderInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Created by Lowell on 2017/6/17.
 */
@RestController
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);


    @Autowired
    private MsgSenderInterface msgSenderInterface;


    @RequestMapping(value = { "/sendMsgToMQ" }, method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json;charset=UTF-8")
    public void sendMsg(@RequestBody Map paras) {

        logger.info("paras:"+paras);
        String json= JSON.toJSONString(paras);
        msgSenderInterface.sendMsgToMQ(json);
    }

}
