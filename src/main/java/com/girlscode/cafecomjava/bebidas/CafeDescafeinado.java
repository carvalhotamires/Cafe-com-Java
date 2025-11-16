package com.girlscode.cafecomjava.bebidas;

import com.girlscode.cafecomjava.core.Bebida;

public class CafeDescafeinado implements Bebida {
    @Override
    public double getCusto() {
        return 7.50;
    }

    @Override
    public String getDescricao() {
        return "Café Descafeinado";
    }
}
