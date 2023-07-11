package solvd.ermakovich.zt.kafka.srteams.config.topology;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;

/**
 * Stream processor for checking animal health indicators.
 *
 * @author Ermakovich Kseniya
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class HealthCheckProcessor {

    /**
     * A Serde that maps json to entity.
     */
    private final JsonSerde<HealthIndicatorsMessage> jsonSerde;

    /**
     * A Predicate that filters unhealthy animals.
     */
    private final Predicate<String, HealthIndicatorsMessage> isAnimalUnhealthy;

    /**
     * Creates kafka stream that checks health indicators and records
     * all unhealthy indicators to {@code health-warnings} topic.
     *
     * @param builder kafka streams builder
     */
    @Autowired
    public void healthWarningsStream(final StreamsBuilder builder) {
        builder.stream("health-indicators",
                        Consumed.with(Serdes.String(), jsonSerde)
                )
                .filter(isAnimalUnhealthy)
                .to("health-warnings", Produced.valueSerde(jsonSerde));
        log.info(builder.build().describe().toString());
    }

}
