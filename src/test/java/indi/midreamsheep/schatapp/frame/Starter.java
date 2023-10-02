package indi.midreamsheep.schatapp.frame;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import indi.midreamsheep.schatapp.frame.net.SChatCommunication;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;
import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.protocol.chat.transmission.SendMessage;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMapping;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessage;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatType;
import indi.midreamsheep.schatapp.frame.net.protocol.resonse.ChatTransmissionEnum;
import indi.midreamsheep.schatapp.frame.net.service.AbstractService;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws Exception {
        SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
        builder.setServerSupporter("localhost", 7524);
        builder.addTypeHandler(ChatTransmissionEnum.SEND_MESSAGE.getCode(), ((ctx, data) -> {
            System.out.println(data);
        }));
        SChatCommunication communication = builder.build();
        communication.login("123456");
        Send sendService = new Send();
        communication.registerService(sendService);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            sendService.send(2, s);
        }
    }

    static class Send extends AbstractService{
        public void send(long id, String message){
            long l = IdUtil.getSnowflake().nextId();
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setId(l);
            chatMessage.setType(ChatType.INDIVIDUAL.getId());
            chatMessage.setMapping(ChatMapping.SEND.getMapping());

            SendMessage sendMessage = new SendMessage();
            sendMessage.setMessageTo(id);
            sendMessage.setMessage(message);

            chatMessage.setData(sendMessage);

            //注册回调
            ChatHandlerIdRecall.addRecall(l,
                    (sender,data)->{
                        System.out.println(data);
                    });

            sender.send(chatMessage);
        }
    }
}
