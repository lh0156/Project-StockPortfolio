package seop.com.stockportfolio.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import seop.com.stockportfolio.stock.domain.dto.request.StockInfo;
import seop.com.stockportfolio.stock.service.StockService;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/inputStock")
    public String inputStock(Model model) throws IOException {

        model.addAttribute("stockNameList", stockService.getAllStocksInfo());

        return "inputStock";
    }

}
