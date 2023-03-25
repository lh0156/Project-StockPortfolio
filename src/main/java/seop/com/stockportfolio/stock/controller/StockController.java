package seop.com.stockportfolio.stock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import seop.com.stockportfolio.stock.domain.dto.request.StockInfo;
import seop.com.stockportfolio.stock.domain.dto.request.StockSelectionForm;
import seop.com.stockportfolio.stock.service.StockService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final ObjectMapper objectMapper;

    @GetMapping("/inputStock")
    public String showInputStock(Model model) throws IOException {

        List<String> stockInfoList = stockService.getAllStockSymbol();

        StockSelectionForm selectedStockList = new StockSelectionForm();
        selectedStockList.setSelectedStocks(new ArrayList<>());

//        String stockNameListJson = objectMapper.writeValueAsString(stockInfoList);

        model.addAttribute("stockInfoList", stockInfoList);
        model.addAttribute("selectedStockList", selectedStockList);

        return "inputStock";
    }

    @PostMapping("/inputStock")
    public String inputStock() throws IOException {

        return "inputStock";
    }

}
