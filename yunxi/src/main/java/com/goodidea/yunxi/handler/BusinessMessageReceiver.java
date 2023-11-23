package com.goodidea.yunxi.handler;

import com.goodidea.yunxi.config.RabbitMQconfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BusinessMessageReceiver {
    /**
     * 消费消息
     */
    @RabbitListener(queues = RabbitMQconfig.BUSINESS_QUEUEA_NAME)
    public void receiveA(Message message, Channel channel) throws IOException {
        String msg=new String(message.getBody());
        System.out.println("进入消费者A{}"+msg);
        boolean ack=true;
        Exception exception=null;
        try {
            if (msg.contains("deadletter")){
                throw new RuntimeException("不存在deadletter");
            }
        } catch (RuntimeException e) {
            ack=false;
            exception=e;
        }
        if (!ack){
            System.out.println("错误信息{ }"+exception.getMessage());
            //设置死信消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }
    }
    /**
     * 消息信息B
     */ @RabbitListener(queues = RabbitMQconfig.BUSINESS_QUEUEB_NAME)
    public void receiveB(Message message,Channel channel) throws IOException {
        String msg = new String(message.getBody());
        System.out.println("进入消费者B{ }"+msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}