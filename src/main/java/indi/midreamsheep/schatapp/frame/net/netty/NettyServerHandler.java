package indi.midreamsheep.schatapp.frame.net.netty;

import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.protocol.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    Map<Integer,ChatHandler> typeHandler;
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        ChatTransmission chatTransmission = JsonUtil.getJsonToBean(msg, ChatTransmission.class);
        System.out.println(chatTransmission);
        ChatHandler a;
        if (chatTransmission.getId()==-1){
            a = typeHandler.get(chatTransmission.getType());
        }else{
            a = ChatHandlerIdRecall.getRecall(chatTransmission.getId());
        }
        if (a==null){
            return;
        }
        a.handler(new ChatSender(ctx.channel()), chatTransmission.getData());
    }

    public NettyServerHandler(Map<Integer,ChatHandler> typeHandler){
        this.typeHandler = typeHandler;
    }


}