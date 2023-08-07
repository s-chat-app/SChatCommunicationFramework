package indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.transmission;

import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateKey {
    private long privateKey;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }
}
