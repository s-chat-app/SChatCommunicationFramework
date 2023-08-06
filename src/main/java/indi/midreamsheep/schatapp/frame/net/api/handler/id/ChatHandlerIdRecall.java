package indi.midreamsheep.schatapp.frame.net.api.handler.id;

import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatHandlerIdRecall {
    private static final Map<Long, ChatHandler> idHandler = new ConcurrentHashMap<>();

    public static void addRecall(long id, ChatHandler handler){
        idHandler.put(id, handler);
    }

    public static ChatHandler getRecall(long id){
        ChatHandler recall = idHandler.get(id);
        idHandler.remove(id);
        return recall;
    }

}
