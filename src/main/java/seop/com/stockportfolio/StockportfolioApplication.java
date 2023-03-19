package seop.com.stockportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import seop.com.stockportfolio.global.finnhub.FinnHubConfig;

@SpringBootApplication
public class StockportfolioApplication {

	public static void main(String[] args) {

		SpringApplication.run(StockportfolioApplication.class, args);
		System.out.println(FinnHubConfig.getPublicKey());
	}

}
