package indi.midreamsheep.schatapp.frame.net.service.system;

import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatMapping;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatMessage;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.system.PrivateKey;
import io.netty.channel.Channel;

public class SystemServiceImpl implements SystemService{

    private final Channel channel;

    public SystemServiceImpl(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void login(long privateKey) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatType.SYSTEM.getId());
        chatMessage.setMapping(ChatMapping.LOGIN.getMapping());
        chatMessage.setData(new PrivateKey(privateKey).toString());
        chatMessage.setId(15151);
        ChatHandlerIdRecall.addRecall(15151,((ctx, data) -> {
            System.out.println("login success");
        }));
        channel.writeAndFlush(chatMessage.toString());
    }
}