package com.girlscode.cafecomjava.contexto;

import com.girlscode.cafecomjava.core.DescontoStrategy;

public class PedidoContexto {
    private DescontoStrategy descontoStrategy;

    public void setStrategy(DescontoStrategy strategy) {
        this.descontoStrategy = strategy;
    }

    public double processarDesconto(double valorTotal) throws IllegalAccessException {
        if(descontoStrategy == null) {
            throw new IllegalAccessException("Nenhuma estratégia de desconto foi definida.");
        }
        return descontoStrategy.aplicarDesconto(valorTotal);
    }
}
