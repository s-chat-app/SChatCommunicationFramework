package indi.midreamsheep.schatapp.frame.net.entity.chat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTypeEnum {
    TEXT(1),
    ;
    private final int code;

}
