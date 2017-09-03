package com.lowell.mdp.receiver.facade.stub;

/**
 * Created by Lowell on 17-7-5.
 */
public interface MsgSenderInterface {

    public boolean sendMsgToMQ(String jsonStr);

}
