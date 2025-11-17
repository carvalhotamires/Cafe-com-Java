package com.girlscode.cafecomjava.contexto;

import com.girlscode.cafecomjava.core.DescontoStrategy;

public class PedidoContexto {
    private DescontoStrategy descontoStrategy;

    public void setStrategy(DescontoStrategy strategy) {
        this.descontoStrategy = strategy;
    }
}
