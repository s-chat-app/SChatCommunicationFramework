package indi.midreamsheep.schatapp.frame.net.service;

import io.netty.channel.Channel;

public class AbstractService {
    protected Channel channel;

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
