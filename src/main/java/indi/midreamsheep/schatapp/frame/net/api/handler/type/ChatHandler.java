package indi.midreamsheep.schatapp.frame.net.api.handler.type;

import io.netty.channel.ChannelHandlerContext;

/**
 * 服务端返回值的处理器
 * @author midreamsheep
 * */
public interface ChatHandler {
    /**
     * 处理器处理方法
     * @param ctx 通道上下文
     * @param data 数据
     * */
    void handler(ChannelHandlerContext ctx, String data);
}
