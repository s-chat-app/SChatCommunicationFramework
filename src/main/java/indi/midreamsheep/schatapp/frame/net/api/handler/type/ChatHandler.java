package indi.midreamsheep.schatapp.frame.net.api.handler.type;

import com.alibaba.fastjson.JSONObject;
import indi.midreamsheep.schatapp.frame.net.netty.ChatSender;
import io.netty.channel.ChannelHandlerContext;

/**
 * 服务端返回值的处理器
 * @author midreamsheep
 * */
public interface ChatHandler {
    /**
     * 处理器处理方法
     * @param sender 发送器
     * @param data 数据
     * */
    void handler(ChatSender sender, JSONObject data) throws Exception;
}
