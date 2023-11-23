package com.goodidea.yunxi.handler;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeadMessageReceiver {
    /**
     * 两个死信队列
     */
    public static final String DEAD_LETTER_QUEUEA_NAME="dead.letter.demo.simple.deadletter.queuea";
    @RabbitListener(queues = DEAD_LETTER_QUEUEA_NAME)
    public void receiveA(Message message, Channel channel) throws IOException {
        System.out.println("进入死信队列{}"+new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}