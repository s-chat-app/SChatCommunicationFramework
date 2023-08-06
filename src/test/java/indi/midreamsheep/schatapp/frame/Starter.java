package indi.midreamsheep.schatapp.frame;

import indi.midreamsheep.schatapp.frame.net.SChatCommunication;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.Message;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.MessageTypeEnum;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.send.SendMessage;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.TransmissionEnum;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
        builder.setServerSupporter("localhost", 7524);
        builder.addTypeHandler(TransmissionEnum.SEND_MESSAGE.getCode(), ((ctx, data) -> {
            System.out.println(data);
        }));
        SChatCommunication communication = builder.build();
        communication.systemService.login(123456);
        //进行注册
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String data = scanner.nextLine();
            SendMessage message = new SendMessage();
            message.setMessageTo(1);
            message.setMessage(new Message(MessageTypeEnum.TEXT,data));
            communication.individualService.sendMsg(message);
        }
    }
}
