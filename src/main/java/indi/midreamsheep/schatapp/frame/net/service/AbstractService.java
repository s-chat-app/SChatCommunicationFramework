package indi.midreamsheep.schatapp.frame.net.service;

import indi.midreamsheep.schatapp.frame.net.netty.ChatSender;
import io.netty.channel.Channel;

public class AbstractService {
    protected ChatSender sender;

    public void setChannel(Channel channel) {
        this.sender = new ChatSender(channel);
    }
}
