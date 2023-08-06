package indi.midreamsheep.schatapp.frame.net.service;

import io.netty.channel.Channel;

public class AbstractService {
    protected final Channel channel;

    public AbstractService(Channel channel) {
        this.channel = channel;
    }
}
