package indi.midreamsheep.schatapp.frame.net.netty;

import indi.midreamsheep.schatapp.frame.net.netty.prototcp.MessageProtocol;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessage;
import io.netty.channel.Channel;


public record ChatSender(Channel channel) {

    public void send(String message) {
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(message.getBytes().length);
        messageProtocol.setContent(message.getBytes());
        channel.writeAndFlush(messageProtocol);
    }

    public void  send(ChatMessage message){
        send(message.toString());
    }

}
