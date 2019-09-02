package info.kmdb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JhipsterReactNativeKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(JhipsterReactNativeKafkaConsumer.class);
    private static final String TOPIC = "topic_jhipsterreactnative";

    @KafkaListener(topics = "topic_jhipsterreactnative", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
