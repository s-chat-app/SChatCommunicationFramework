package indi.midreamsheep.schatapp.frame.net.entity.chat;

import com.alibaba.fastjson.JSONException;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private long id;
    private int type;
    private String mapping;
    private String data;

    @Override
    public String toString(){
        return JsonUtil.getBeanToJson(this);
    }
}
