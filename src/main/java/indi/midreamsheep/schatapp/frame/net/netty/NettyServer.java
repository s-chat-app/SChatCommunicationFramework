package indi.midreamsheep.schatapp.frame.net.netty;

import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.netty.prototcp.MessageDecoder;
import indi.midreamsheep.schatapp.frame.net.netty.prototcp.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;

public final class NettyServer {

    public ChatSender run(String ip, int port, Map<Integer, ChatHandler> typeHandlerHashMap) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch){
                        //得到pipeline
                        ChannelPipeline pipeline = ch.pipeline();
                        //加入相关handler
                        pipeline.addLast("decoder", new MessageDecoder());
                        pipeline.addLast("encoder", new MessageEncoder());
                        //加入自定义的handler
                        pipeline.addLast(new NettyServerHandler(typeHandlerHashMap));
                    }
                });
        return new ChatSender(bootstrap.connect(ip, port).sync().channel());
    }
}
