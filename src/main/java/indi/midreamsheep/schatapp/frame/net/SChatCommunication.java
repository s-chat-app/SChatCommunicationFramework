package indi.midreamsheep.schatapp.frame.net;

import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.netty.NettyServer;
import indi.midreamsheep.schatapp.frame.net.service.AbstractService;
import io.netty.channel.Channel;

import java.util.Map;

public class SChatCommunication {

    private final Channel channel;

    public SChatCommunication(String ip, int port, Map<Integer, ChatHandler> typeHandlerMap) throws InterruptedException {
        channel = new NettyServer().run(ip, port, typeHandlerMap);
    }

    public void registerService(AbstractService service){
        service.setChannel(channel);
    }


}