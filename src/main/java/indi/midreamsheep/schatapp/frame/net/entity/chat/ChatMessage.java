package indi.midreamsheep.schatapp.frame.net.entity.chat;

import com.alibaba.fastjson.JSONException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private int id;
    private int type;
    private String mapping;
    private String data;
}
