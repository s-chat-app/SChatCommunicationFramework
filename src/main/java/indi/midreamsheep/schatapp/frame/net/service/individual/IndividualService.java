package indi.midreamsheep.schatapp.frame.net.service.individual;

import indi.midreamsheep.schatapp.frame.net.entity.chat.message.Message;
import indi.midreamsheep.schatapp.frame.net.entity.chat.message.send.SendMessage;

public interface IndividualService  {
    void sendMsg(SendMessage message);

    void editMsg(Message message);

    void deleteMsg(Message message);
}
