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
 * Kafka streams configuration.
 *
 * @author Ermakovich Kseniya
 */
@Configuration
@EnableKafka
@EnableKafkaStreams
public class StreamsConfig {

    /**
     * Creates topic to hold health warnings of zoo animals.
     *
     * @return kafka topic
     */
    @Bean
    public NewTopic healthWarnings() {
        return TopicBuilder.name("health-warnings")
                .partitions(3)
                .build();
    }

    /**
     * Creates topic to hold health indicators of zoo animals.
     * Includes blood pressure, heart rate, temperature.
     *
     * @return kafka topic
     */
    @Bean
    public NewTopic healthIndicators() {
        return TopicBuilder.name("health-indicators")
                .partitions(3)
                .build();
    }

    /**
     * Creates a Serde that provides serialization and deserialization
     * in JSON format.
     *
     * @param objectMapper default JSON mapper
     * @param kafkaProperties properties for kafka.
     * @return json serde
     */
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
