package indi.midreamsheep.schatapp.frame.net.netty;

import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessage;
import io.netty.channel.Channel;
import lombok.Getter;

@Getter
public record ChatSender(Channel channel) {

    public void send(String message) {
        channel.writeAndFlush(message);
    }

    public void send(ChatMessage message){
        channel.writeAndFlush(message.toString());
    }

}
