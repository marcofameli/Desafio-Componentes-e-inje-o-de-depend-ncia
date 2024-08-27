package desafio.nelio.entities;

import java.math.BigDecimal;

public class Order {
    public static int nextCode = 1000;
    private final int code;
    private BigDecimal basicValue;
    private BigDecimal discountPercentage;


    public Order(BigDecimal basicValue, BigDecimal discountPercentage) {
        this.code = nextCode++;
        this.basicValue = basicValue;
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getBasicValue() {
        return basicValue;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public BigDecimal getDiscountAmount() {
        return basicValue.multiply(discountPercentage).divide(new BigDecimal("100"));
    }

    public BigDecimal getFinalValue() {
        return basicValue.subtract(getDiscountAmount());
    }

    public int getCode(){
        return code;
    }
}

