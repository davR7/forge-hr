package com.davr7.mspayroll.domain.utils;

abstract public class INSSCalc {

    public static Double exec(Double basicPay) {
        if (basicPay <= 1412.00){
            return basicPay * 0.075;
        }
        else if (basicPay > 1412.01 && basicPay < 2668.68){
            return basicPay * 0.09 - 21.18;
        }
        else if (basicPay > 2668.69 && basicPay < 4000.03){
            return basicPay * 0.12 - 101.18;
        }
        else if (basicPay > 4000.04 && basicPay < 7786.02){
            return basicPay * 0.14 - 181.18;
        }
        else {
            return 7786.02 * 0.14 - 181.18;
        }
    }
}
