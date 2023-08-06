package indi.midreamsheep.schatapp.frame.net;

import indi.midreamsheep.schatapp.frame.net.api.handler.ChatTypeHandlerConfiguration;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;

import java.util.HashMap;
import java.util.Map;

public class SChatCommunicationBuilder {

    private final Map<Integer,ChatHandler> typeHandlerMap = new HashMap<>();

    private String ip;
    private int port;

    public void addTypeHandler(Integer type, ChatHandler handler){
        typeHandlerMap.put(type,handler);
    }

    public void addTypeHandler(ChatTypeHandlerConfiguration configuration){
        typeHandlerMap.putAll(configuration.getTypeHandlerMap());
    }

    public void setServerSupporter(String ip,int port){
        this.ip = ip;
        this.port = port;
    }
    public SChatCommunication build() throws InterruptedException {
        return new SChatCommunication(ip,port,typeHandlerMap);
    }
}
