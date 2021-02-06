package it.arteprogrammazione.kafka.listener;


import it.arteprogrammazione.kafka.config.Constants;
import it.arteprogrammazione.kafka.model.Person;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final String TOPIC = "test-topic";

    @KafkaListener(topics = TOPIC,
            groupId = Constants.JSON_GROUP_ID,
            containerFactory = "personKafkaListenerFactory"
    )
    public void consumeJson(Person person) {
        System.out.println("Consumed JSON Message: " + person);
    }
}
