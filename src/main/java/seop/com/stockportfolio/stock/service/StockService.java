package seop.com.stockportfolio.stock.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import seop.com.stockportfolio.global.finnhub.FinnHubConfig;
import seop.com.stockportfolio.stock.domain.dto.request.StockInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public List<StockInfo> getAllStocksInfo() throws IOException {
        String url = "https://finnhub.io/api/v1/stock/symbol?exchange=US&token=" + FinnHubConfig.getPublicKey();
        String response = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(response, new TypeReference<List<StockInfo>>() {});
    }

    public List<String> getAllStockSymbol() throws IOException {
        String url = "https://finnhub.io/api/v1/stock/symbol?exchange=US&token=" + FinnHubConfig.getPublicKey();
        String response = restTemplate.getForObject(url, String.class);
        List<StockInfo> stockInfoList = objectMapper.readValue(response, new TypeReference<List<StockInfo>>() {});
        List<String> stockSymbolList = new ArrayList<>();

        for (StockInfo stockInfo : stockInfoList) {
            stockSymbolList.add(stockInfo.getSymbol());
        }

        return stockSymbolList;
    }

}
