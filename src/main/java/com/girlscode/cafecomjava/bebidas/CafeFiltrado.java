package com.girlscode.cafecomjava.bebidas;

import com.girlscode.cafecomjava.core.Bebida;

public class CafeFiltrado implements Bebida {
    @Override
    public double getCusto() {
        return 4.00;
    }

    @Override
    public String getDescricao() {
        return "Café Filtrado";
    }
}
