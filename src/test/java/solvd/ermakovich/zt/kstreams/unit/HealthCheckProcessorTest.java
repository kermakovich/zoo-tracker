package solvd.ermakovich.zt.kstreams.unit;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.TestInputTopic;
import org.apache.kafka.streams.TestOutputTopic;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.TopologyTestDriver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;
import solvd.ermakovich.zt.helper.BaseTest;
import solvd.ermakovich.zt.helper.TopologyDriverBaseProperties;
import solvd.ermakovich.zt.kafka.srteams.config.topology.HealthCheckProcessor;

/**
 * @author Ermakovich Kseniya
 */
@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
class HealthCheckProcessorTest extends BaseTest {

    private TestInputTopic<String, HealthIndicatorsMessage> inputTopic;
    private TestOutputTopic<String, HealthIndicatorsMessage> outputTopic;
    private TopologyTestDriver testDriver;

    @Autowired
    private HealthCheckProcessor healthCheckProcessor;

    @BeforeEach
    public void setup() {
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        healthCheckProcessor.healthWarningsStream(streamsBuilder);
        Topology topology = streamsBuilder.build();
        testDriver = new TopologyTestDriver(
                topology, new TopologyDriverBaseProperties()
                .getKafkaStreamProperties()
        );
        inputTopic = testDriver.createInputTopic("health-indicators",
                Serdes.String().serializer(),
                new JsonSerde<>(HealthIndicatorsMessage.class).serializer());
        outputTopic = testDriver.createOutputTopic("health-warnings",
                Serdes.String().deserializer(),
                new JsonSerde<>(HealthIndicatorsMessage.class).deserializer());
    }

    @AfterEach
    public void shutDown() {
        testDriver.close();
    }

    @Test
    void verifiesEmptyOutputTopic() {
        inputTopic.pipeInput(BaseTest.goodHealthIndicatorsMessage);
        MatcherAssert.assertThat(
                "topic should be empty",
                outputTopic.isEmpty(),
                Matchers.equalTo(true)
        );
    }

    @Test
    void verifiesOutputTopicHasRecord() {
        inputTopic.pipeInput(BaseTest.badHealthIndicatorsMessage);
        MatcherAssert.assertThat(
                "topic should not be empty",
                outputTopic.isEmpty(),
                Matchers.equalTo(false)
        );
    }

}
