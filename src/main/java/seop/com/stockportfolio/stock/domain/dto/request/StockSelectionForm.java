package seop.com.stockportfolio.stock.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StockSelectionForm {
    private List<String> selectedStocks;

}