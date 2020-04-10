package com.lectricas.olymp;

import java.math.BigDecimal;

public class PowerOfTwoTable {


    public static void main(String[] args) {
        BigDecimal power = new BigDecimal(4);
        BigDecimal what = new BigDecimal(4);
        int n = 4;
        for (int i = 1; i < n; i++) {
            power = what.pow(power.intValue());
            System.out.println(power);
            System.out.println(power.toString().length());
        }
    }
}
