package com.lowell.mdp.receiver.facade.service;

import com.lowell.mdp.receiver.facade.config.RabbitMQConfig;
import com.lowell.mdp.receiver.facade.stub.MsgSenderInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by HP on 2017/7/7.
 */
@org.springframework.stereotype.Service
@com.alibaba.dubbo.config.annotation.Service(protocol = "dubbo")
public class MsgSender implements MsgSenderInterface {

    private static final Logger logger = LoggerFactory.getLogger(MsgSender.class);


    @Autowired
    private AmqpTemplate rabbitTemplate;
    public boolean sendMsgToMQ(String jsonStr) {

        logger.info("jsonStr:"+jsonStr);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, jsonStr);
        return true;
    }
}
