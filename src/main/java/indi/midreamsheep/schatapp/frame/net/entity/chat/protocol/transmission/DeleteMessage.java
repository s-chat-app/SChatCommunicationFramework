package indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.transmission;

import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.data.ChatTransmissionData;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMessage implements ChatTransmissionData {
    private long deleteId;

    @Override
    public String toString() {
        return JsonUtil.getBeanToJson(this);
    }

    @Override
    public String toJson() {
        return toString();
    }
}
