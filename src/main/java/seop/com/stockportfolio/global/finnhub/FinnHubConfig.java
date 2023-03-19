package seop.com.stockportfolio.global.finnhub;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

@Component
public class FinnHubConfig {
    private static final String CONFIG_FILE_NAME = "finnhub.yml";
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = Objects.requireNonNull(FinnHubConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME))) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPublicKey() {
        return properties.getProperty("PUBLIC_KEY");
    }
}