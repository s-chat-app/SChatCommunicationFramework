package indi.midreamsheep.schatapp.frame.net.protocol.chat.transmission;

import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessageData;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户的发送消息接收实体类
 * */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessage extends ChatMessageData {
    private long messageTo;
    private String message;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
