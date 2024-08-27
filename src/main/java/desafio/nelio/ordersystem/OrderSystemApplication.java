package desafio.nelio.ordersystem;

import desafio.nelio.entities.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@SpringBootApplication
public class OrderSystemApplication {
    private static final Logger logger = LoggerFactory.getLogger(OrderSystemApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrderSystemApplication.class, args);

        OrderService orderService = context.getBean(OrderService.class);

        testOrder(orderService, new BigDecimal("150.0"), new BigDecimal("20.0"));
        testOrder(orderService, new BigDecimal("800.0"), new BigDecimal("10.0"));
        testOrder(orderService, new BigDecimal("95.90"), new BigDecimal("0"));
    }

    private static void testOrder(OrderService orderService, BigDecimal basicValue, BigDecimal discountPercentage) {
        Order order = new Order(basicValue, discountPercentage);
        BigDecimal totalValue = orderService.calculateTotalOrder(order);
        logger.info("Pedido código {}, Valor básico: R$ {}, Desconto: {}%, Valor total: R$ {}",
                order.getCode(),basicValue, discountPercentage, totalValue);
    }
}