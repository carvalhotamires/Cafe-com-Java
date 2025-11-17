package com.girlscode.cafecomjava.strategy;

import com.girlscode.cafecomjava.core.DescontoStrategy;

public class DescontoMembro implements DescontoStrategy {
    @Override
    public double aplicarDesconto(double valorTotal) {
        System.out.println("-10% na sua conta. Desconto de Membro aplicado com sucesso!");
        return valorTotal * 0.90;
    }
}
