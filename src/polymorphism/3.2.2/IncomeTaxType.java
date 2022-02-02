import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeTaxType extends TaxType{
    private final int BASE_TAX = 13;

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(BASE_TAX));
    }
}
