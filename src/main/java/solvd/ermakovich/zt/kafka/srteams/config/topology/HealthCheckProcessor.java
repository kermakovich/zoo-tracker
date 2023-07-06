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
 * @author Ermakovich Kseniya
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class HealthCheckProcessor {

    private final JsonSerde<HealthIndicatorsMessage> jsonSerde;
    private final Predicate<String, HealthIndicatorsMessage> healthyPredicate;

    @Autowired
    public void healthWarningsStream(final StreamsBuilder builder) {
        builder.stream("health-indicators",
                        Consumed.with(Serdes.String(), jsonSerde)
                )
                .filter(healthyPredicate)
                .to("health-warnings", Produced.valueSerde(jsonSerde));
        log.info(builder.build().describe().toString());
    }

}
