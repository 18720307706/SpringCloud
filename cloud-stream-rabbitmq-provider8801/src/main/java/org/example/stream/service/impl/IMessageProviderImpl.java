package org.example.stream.service.impl;

import org.example.stream.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author Lch on 2020/11/2
 */
@EnableBinding(Source.class) //定义消息通道
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String id= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(id).build());
        System.out.println("订单号："+id);
        return null;
    }
}