package indi.midreamsheep.schatapp.frame.net.protocol.chat.ecc;

import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.Data;

@Data
public class EccKey {
    private String privateKey;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
