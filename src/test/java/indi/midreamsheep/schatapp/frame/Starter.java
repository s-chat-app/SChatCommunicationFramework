package indi.midreamsheep.schatapp.frame;

import indi.midreamsheep.schatapp.frame.net.SChatCommunication;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;
import indi.midreamsheep.schatapp.frame.net.protocol.resonse.ChatTransmissionEnum;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
        builder.setServerSupporter("localhost", 7524);
        builder.addTypeHandler(ChatTransmissionEnum.SEND_MESSAGE.getCode(), ((ctx, data) -> {
            System.out.println(data);
        }));
        builder.addTypeHandler(ChatTransmissionEnum.LOGIN.getCode(), ((ctx, data) -> {
            System.out.println(data);
        }));
        SChatCommunication communication = builder.build();

    }
}
