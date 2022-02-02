import java.math.BigDecimal;

public class TaxService {
    public void payOut(BigDecimal taxAmount){
        System.out.println("Уплачен налог в размере " + taxAmount);
    }
}
