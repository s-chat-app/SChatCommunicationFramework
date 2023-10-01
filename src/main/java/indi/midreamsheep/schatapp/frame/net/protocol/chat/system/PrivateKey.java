package indi.midreamsheep.schatapp.frame.net.protocol.chat.system;

import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessageData;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateKey extends ChatMessageData {
    private String privateKey;

    private String publicKey;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

}
