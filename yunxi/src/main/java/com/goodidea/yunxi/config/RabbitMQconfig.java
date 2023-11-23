package com.goodidea.yunxi.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class RabbitMQconfig {
    /**
     * 业务Exchange
     */ public static final String BUSINESS_EXCHANGE_NAME="dead.letter.demo.simple.business.exchange";
    /**
     * 业务队列
     */
    public static final String BUSINESS_QUEUEA_NAME="dead.letter.demo.simple.business.queuea";
    public static final String BUSINESS_QUEUEB_NAME="dead.letter.demo.simple.business.queueb";

    /**
     * 死信Exchange
     */ public static final String DEAD_LETTER_EXCHANGE="dead.letter.demo.simple.deadletter.exchange";
    /**
     * 路由key
     */ public static final String DEAD_LETTER_QUEUEA_ROUTING_KEY="dead.letter.demo.simple.deadletter.queuea";
    /**
     * 一个死信队列
     */
    public static final String DEAD_LETTER_QUEUEA_NAME="dead.letter.demo.simple.deadletter.queuea";

    /**
     * 声明业务Exchange
     */ @Bean("businessExchange")
    public FanoutExchange businessExchange(){
        //广播模式
        return  new FanoutExchange((BUSINESS_EXCHANGE_NAME));
    }

    /**
     * 声明死信Exchange
     */ @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange(){
        //点对点模式模式
        return  new DirectExchange((DEAD_LETTER_EXCHANGE));
    }

    /**
     * 声明业务队列A
     * @return
     */
    @Bean("businessQueueA")
    public Queue businessQueueA(){
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("x-dead-letter-exchange",DEAD_LETTER_EXCHANGE);
        map.put("x-dead-letter-routing-key",DEAD_LETTER_QUEUEA_ROUTING_KEY);
        return QueueBuilder.durable(BUSINESS_QUEUEA_NAME).withArguments(map).build();
    }

    /**
     * 声明业务队列B
     * @return
     */
    @Bean("businessQueueB")
    public Queue businessQueueB(){
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("x-dead-letter-exchange",DEAD_LETTER_EXCHANGE);
        map.put("x-dead-letter-routing-key",DEAD_LETTER_QUEUEA_ROUTING_KEY);
        return QueueBuilder.durable(BUSINESS_QUEUEB_NAME).withArguments(map).build();
    }

    /**
     * 声明死信队列A
     */ @Bean("deadLetterQueueA")
    public Queue deadLetterQueueA(){
        return  new Queue(DEAD_LETTER_QUEUEA_NAME);
    }

//    /**
//     * 声明死信队列B
//     */ @Bean("deadLetterQueueB")
//    public Queue deadLetterQueueB(){
//        return  new Queue(DEAD_LETTER_QUEUEB_NAME);
//    }

    /**
     * 声明业务队列A绑定关系
     */
    @Bean
    public Binding businessBindingA(@Qualifier("businessQueueA") Queue queue,
                                    @Qualifier("businessExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    /**
     * 声明业务队列B绑定关系
     */
    @Bean
    public Binding businessBindingB(@Qualifier("businessQueueB") Queue queue,
                                    @Qualifier("businessExchange")FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    /**
     * 声明死信队列A绑定关系
     */
    @Bean
    public Binding deadLetterBindingA(@Qualifier("deadLetterQueueA")Queue queue,
                                      @Qualifier("deadLetterExchange")DirectExchange exchange)   {
        return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEA_ROUTING_KEY);
    }

//    /**
//     * 声明死信队列B绑定关系
//     */
//    @Bean
//    public Binding deadLetterBindingB(@Qualifier("deadLetterQueueB")Queue queue,
//                                      @Qualifier("deadLetterExchange")DirectExchange exchange)   {
//        return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEB_ROUTING_KEY);
//    }
}