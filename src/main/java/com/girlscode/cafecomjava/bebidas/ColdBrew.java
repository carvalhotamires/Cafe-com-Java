package com.girlscode.cafecomjava.bebidas;

import com.girlscode.cafecomjava.core.Bebida;

public class ColdBrew implements Bebida {
    @Override
    public double getCusto() {
        return 6.00;
    }

    @Override
    public String getDescricao() {
        return "ColdBrew";
    }
}
