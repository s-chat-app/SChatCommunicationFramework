package indi.midreamsheep.schatapp.frame.net.netty;

import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.netty.prototcp.MessageProtocol;
import indi.midreamsheep.schatapp.frame.net.protocol.resonse.ChatTransmission;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class NettyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    Map<Integer,ChatHandler> typeHandler;
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("收到消息");
        System.out.println(new String(msg.getContent(), StandardCharsets.UTF_8));
        ChatTransmission chatTransmission = JsonUtil.getJsonToBean(new String(msg.getContent(), StandardCharsets.UTF_8), ChatTransmission.class);
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