package solvd.ermakovich.zt.kstreams.unit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicatorsMap;

/**
 * @author Ermakovich Kseniya
 */
@SuppressWarnings("JTCOP.RuleAllTestsHaveProductionClass")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        KafkaAutoConfiguration.class})
@Configuration
@ComponentScan(basePackages = "solvd.ermakovich.zt.kafka.srteams, " +
        "solvd.ermakovich.zt.service", basePackageClasses =
        {DefaultHealthIndicatorsMap.class, KafkaProperties.class})
public class TestConfig { }
