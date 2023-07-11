package solvd.ermakovich.zt.domain.health.indicators;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.cactoos.Scalar;
import org.springframework.stereotype.Service;

/**
 * @author Ermakovich Kseniya
 */
@Service
public class DefaultHealthIndicatorsMap
        implements Scalar<Map<String, DefaultHealthIndicators>> {

    /**
     * Contains predefined indicators from JSON file.
     */
    private Map<String, DefaultHealthIndicators> map;

    /**
     * Loads predefined indicators from JSON file.
     */
    @PostConstruct
    void init() throws IOException {
        try (InputStream s = getClass().getClassLoader()
                .getResourceAsStream("default_health_indicators.json")) {
            map =  new ObjectMapper().readValue(
                    s, new TypeReference<>() { }
            );
        }
    }

    @Override
    public Map<String, DefaultHealthIndicators> value() {
        return map;
    }

}
