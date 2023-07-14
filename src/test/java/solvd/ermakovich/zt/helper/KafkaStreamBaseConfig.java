package solvd.ermakovich.zt.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonSerde;

/**
 * @author Ermakovich Kseniya
 */
@SuppressWarnings("JTCOP.RuleAllTestsHaveProductionClass")
public class KafkaStreamBaseConfig {

    public Properties getProperties() {
        Map<String, Object> props = new HashMap<>(4);
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "zoo-tracker");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
                Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
                JsonSerde.class.getName());
        return new KafkaStreamsConfiguration(props).asProperties();
    }

}
