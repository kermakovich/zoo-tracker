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

    private static final String JSON_FILE_PATH =
            "default_health_indicators.json";
    private Map<String, DefaultHealthIndicators> map;


    @PostConstruct
    void init() throws IOException {
        try (InputStream s = getClass().getClassLoader()
                .getResourceAsStream(JSON_FILE_PATH)) {
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
