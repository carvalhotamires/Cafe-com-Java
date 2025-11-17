package com.girlscode.cafecomjava.strategy;

import com.girlscode.cafecomjava.core.DescontoStrategy;

public class SemDesconto implements DescontoStrategy {
    @Override
    public double aplicarDesconto(double valorTotal) {
        System.out.println("Sem desconto aplicado");
        return valorTotal;
    }
}
