package com.girlscode.cafecomjava.decorador;

import com.girlscode.cafecomjava.core.Bebida;

public class ChantillyDecorator extends ToppingDecorator{

    public ChantillyDecorator(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return bebidaDecorada.getDescricao() + " + Chantilly";
    }

    @Override
    public double getCusto() {
        return bebidaDecorada.getCusto() + 3.00;
    }
}
