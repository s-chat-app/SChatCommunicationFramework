package indi.midreamsheep.schatapp.frame.net.service.individual;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatMapping;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatMessage;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.Message;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.send.SendMessage;
import indi.midreamsheep.schatapp.frame.net.service.AbstractService;
import io.netty.channel.Channel;

public class IndividualServiceImpl extends AbstractService implements IndividualService{

    public IndividualServiceImpl(Channel channel) {
        super(channel);
    }

    @Override
    public void sendMsg(SendMessage message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatType.INDIVIDUAL.getId());
        chatMessage.setMapping(ChatMapping.SEND.getMapping());
        chatMessage.setData(message.toString());
        long id = IdUtil.getSnowflake().nextId();
        chatMessage.setId(id);
        ChatHandlerIdRecall.addRecall(id,((ctx, data) -> {
            System.out.println(data);
            System.out.println(id+"->send success");
        }));
        channel.writeAndFlush(chatMessage.toString());
    }

    @Override
    public void editMsg(Message message) {}

    @Override
    public void deleteMsg(Message message) {}
}
