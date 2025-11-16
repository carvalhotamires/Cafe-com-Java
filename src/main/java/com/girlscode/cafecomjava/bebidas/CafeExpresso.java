package com.girlscode.cafecomjava.bebidas;

import com.girlscode.cafecomjava.core.Bebida;

public class CafeExpresso implements Bebida {
    @Override
    public double getCusto() {
        return 5.00;
    }

    @Override
    public String getDescricao() {
        return "Cafe Expresso";
    }
}
