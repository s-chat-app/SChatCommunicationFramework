package indi.midreamsheep.schatapp.frame.net.entity.chat.message.send;

import indi.midreamsheep.schatapp.frame.net.entity.chat.message.Message;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessage {
    private long messageTo;
    private Message message;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
