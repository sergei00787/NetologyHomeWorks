import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProgressiveTaxType extends TaxType{
    private final int BASE_TAX = 10;
    private final int PROGRESSIVE_TAX = 15;


    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(100000)) >= 1) {
            return amount.divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN)
                    .multiply(BigDecimal.valueOf(PROGRESSIVE_TAX));
        }
        return amount.divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(BASE_TAX));
    }
}
