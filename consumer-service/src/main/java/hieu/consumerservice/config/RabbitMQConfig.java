package hieu.consumerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j(topic = "RABBIT-CONFIG")
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "exampleQueue";

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message) {
        log.info("Received message:{}", message);
        System.out.println("Received message: " + message);
    }
}
