package info.kmdb.web.rest;

import info.kmdb.service.JhipsterReactNativeKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-react-native-kafka")
public class JhipsterReactNativeKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterReactNativeKafkaResource.class);

    private JhipsterReactNativeKafkaProducer kafkaProducer;

    public JhipsterReactNativeKafkaResource(JhipsterReactNativeKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
