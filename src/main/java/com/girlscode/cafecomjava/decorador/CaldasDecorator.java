package com.girlscode.cafecomjava.decorador;

import com.girlscode.cafecomjava.core.Bebida;

public class CaldasDecorator extends ToppingDecorator{

    public CaldasDecorator(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return bebidaDecorada.getDescricao() + " + calda";
    }

    @Override
    public double getCusto() {
        return bebidaDecorada.getCusto() + 3.50;
    }
}
