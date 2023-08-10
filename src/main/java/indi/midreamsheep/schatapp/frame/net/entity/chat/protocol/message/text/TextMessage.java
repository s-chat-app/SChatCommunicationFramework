package indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.message.text;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TextMessage {
    private String text;
    private long replyMessageId;
}
