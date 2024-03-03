package com.davr7.mspayroll.domain;

import com.davr7.mspayroll.domain.utils.INSSCalc;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getBasicWage() {
        return dailyIncome * days;
    }

    public Double getDiscountInss() {
        return INSSCalc.exec(dailyIncome * days);
    }

    public Double getGrossWage() {
        return dailyIncome * days - getDiscountInss();
    }
}
