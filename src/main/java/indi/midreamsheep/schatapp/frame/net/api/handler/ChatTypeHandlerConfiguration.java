package indi.midreamsheep.schatapp.frame.net.api.handler;

import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;

import java.util.Map;

public interface ChatTypeHandlerConfiguration {
    Map<Integer, ChatHandler> getTypeHandlerMap();
}
