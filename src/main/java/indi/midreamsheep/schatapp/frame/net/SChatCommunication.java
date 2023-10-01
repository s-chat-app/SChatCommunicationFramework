package indi.midreamsheep.schatapp.frame.net;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.netty.ChatSender;
import indi.midreamsheep.schatapp.frame.net.netty.NettyServer;
import indi.midreamsheep.schatapp.frame.net.netty.NettyServerHandler;
import indi.midreamsheep.schatapp.frame.net.protocol.chat.ecc.EccKey;
import indi.midreamsheep.schatapp.frame.net.protocol.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMapping;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatMessage;
import indi.midreamsheep.schatapp.frame.net.protocol.request.ChatType;
import indi.midreamsheep.schatapp.frame.net.service.AbstractService;
import indi.midreamsheep.schatapp.frame.net.util.protocol.ECCUtils;
import lombok.Setter;

import java.security.KeyPair;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class SChatCommunication {

    private final ChatSender sender;

    private String privateKey;

    private final AtomicInteger isLogin = new AtomicInteger(0);

    public SChatCommunication(String ip, int port, Map<Integer, ChatHandler> typeHandlerMap) throws InterruptedException {
        sender = new NettyServer().run(ip, port, typeHandlerMap);
    }

    public void registerService(AbstractService service){
        service.setChannel(sender.getChannel());
    }

    public void login(String privateKey) throws Exception {
        //生成私钥
        KeyPair ec = ECCUtils.initKey(256, "EC");
        String publicKeyBase64 = Base64.getEncoder().encodeToString(ec.getPublic().getEncoded());
        String privateKeyBase64 = Base64.getEncoder().encodeToString(ec.getPrivate().getEncoded());
        //发送公钥
        PrivateKey privateKeyData = new PrivateKey(privateKey, publicKeyBase64);
        //生成id
        long l = IdUtil.getSnowflake().nextId();
        //注册回调
        ChatHandlerIdRecall.addRecall(l,
                (sender,data)->{
                    String string = data.getString("privateKey");
                    //解密数据
                    string = ECCUtils.decryptByPrivateKey(string, privateKeyBase64);
                    //将私钥存入
                    this.privateKey = string;
                    isLogin.set(1);
                });
        //消息封装
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setId(l);
        chatMessage.setData(privateKeyData);
        chatMessage.setType(ChatType.SYSTEM.getId());
        chatMessage.setMapping(ChatMapping.LOGIN.getMapping());

        sender.send(chatMessage);
    }

}