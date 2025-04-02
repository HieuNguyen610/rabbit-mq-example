package hieu.consumerservice.controller;

import hieu.producerservice.service.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "MESSAGE-CONTROLLER")
public class MessageController {

    private final MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        log.info("Sending message: {}", message);
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}
