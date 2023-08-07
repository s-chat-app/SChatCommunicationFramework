package indi.midreamsheep.schatapp.frame;

import indi.midreamsheep.schatapp.frame.net.SChatCommunication;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.TransmissionEnum;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.transmission.SendMessage;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
        builder.setServerSupporter("localhost", 7524);
        builder.addTypeHandler(TransmissionEnum.SEND_MESSAGE.getCode(), ((ctx, data) -> {
            System.out.println(data);
        }));
        builder.addTypeHandler(TransmissionEnum.LOGIN.getCode(), ((ctx, data) -> {
            System.out.println(data);
        }));
        SChatCommunication communication = builder.build();
        communication.systemService.login(1234567);
        //进行注册
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String data = scanner.nextLine();
            SendMessage message = new SendMessage();
            message.setMessageTo(1);
            message.setMessage(message.toString());
            communication.individualService.sendMsg(message);
        }
    }
}
