package indi.midreamsheep.schatapp.frame.net;

import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.netty.NettyServer;
import indi.midreamsheep.schatapp.frame.net.service.individual.IndividualService;
import indi.midreamsheep.schatapp.frame.net.service.individual.IndividualServiceImpl;
import indi.midreamsheep.schatapp.frame.net.service.system.SystemService;
import indi.midreamsheep.schatapp.frame.net.service.system.SystemServiceImpl;
import io.netty.channel.Channel;

import java.util.Map;

public class SChatCommunication {

    private final Channel channel;
    public final IndividualService individualService;
    public final SystemService systemService;

    public SChatCommunication(String ip, int port, Map<Integer, ChatHandler> typeHandlerMap) throws InterruptedException {
        channel = new NettyServer().run(ip, port, typeHandlerMap);
        individualService = new IndividualServiceImpl(channel);
        systemService = new SystemServiceImpl(channel);
    }


}