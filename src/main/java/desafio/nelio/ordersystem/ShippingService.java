package desafio.nelio.ordersystem;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ShippingService {

    public BigDecimal calculateShipping(BigDecimal basicValue) {
        if (basicValue.compareTo(new BigDecimal("200.00")) >= 0) {
            return BigDecimal.ZERO;
        } else if (basicValue.compareTo(new BigDecimal("100.00")) >= 0) {
            return new BigDecimal("12.00");
        } else {
            return new BigDecimal("20.00");
        }
    }
}