package desafio.nelio.ordersystem;

import desafio.nelio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final ShippingService shippingService;

    @Autowired
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public BigDecimal calculateTotalOrder(Order order) {
        BigDecimal discountedValue = order.getFinalValue();
        BigDecimal shippingCost = calculateShippingCost(order);
        return calculateFinalValue(discountedValue, shippingCost);
    }

    private BigDecimal calculateShippingCost(Order order) {
        return shippingService.calculateShipping(order.getBasicValue());
    }

    private BigDecimal calculateFinalValue(BigDecimal discountedValue, BigDecimal shippingCost) {
        return discountedValue.add(shippingCost);
    }
}