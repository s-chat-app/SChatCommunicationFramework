package indi.midreamsheep.schatapp.frame.net.protocol.chat.transmission;

import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessageData;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户删除消息数据的接收实体类
 * */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMessage extends ChatMessageData {
    private long deleteId;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

}
