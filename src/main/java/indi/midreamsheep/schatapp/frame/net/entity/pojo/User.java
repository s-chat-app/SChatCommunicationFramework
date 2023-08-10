package indi.midreamsheep.schatapp.frame.net.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private String data;
    private Timestamp time;
}