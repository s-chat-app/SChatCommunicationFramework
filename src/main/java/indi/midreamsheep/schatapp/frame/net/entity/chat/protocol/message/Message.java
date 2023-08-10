package indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.message;

import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
    private int messageType;
    private String data;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    public Message(MessageTypeEnum messageType, String data) {
        this.messageType = messageType.getCode();
        this.data = data;
    }
}
