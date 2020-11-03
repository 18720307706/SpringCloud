package org.example.stream.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Lch on 2020/11/3
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("${server.port}")
    private  String serverPort;

    @StreamListener(Sink.INPUT)
    public  void  input(Message<String> message){
        System.out.println("消费者1号,---> 接收到消息"+message.getPayload()+"port:"+serverPort);
    }
}