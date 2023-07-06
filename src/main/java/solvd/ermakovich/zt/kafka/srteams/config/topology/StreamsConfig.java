package solvd.ermakovich.zt.kafka.srteams.config.topology;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonSerde;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;

/**
 * @author Ermakovich Kseniya
 */
@Configuration
@EnableKafka
@EnableKafkaStreams
public class StreamsConfig {

    @Bean
    public NewTopic healthWarnings() {
        return TopicBuilder.name("health-warnings")
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic healthIndicators() {
        return TopicBuilder.name("health-indicators")
                .partitions(3)
                .build();
    }

    @Bean
    public JsonSerde<HealthIndicatorsMessage> healthIndicatorsJsonSerde(
            final ObjectMapper objectMapper,
            final KafkaProperties kafkaProperties
    ) {
        JsonSerde<HealthIndicatorsMessage> serde = new JsonSerde<>(
                HealthIndicatorsMessage.class, objectMapper
        );
        serde.deserializer().configure(
                kafkaProperties.buildConsumerProperties(), false
        );
        serde.serializer().configure(
                kafkaProperties.buildProducerProperties(), false
        );
        return serde;
    }

}
