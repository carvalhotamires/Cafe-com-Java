package com.girlscode.cafecomjava.decorador;

import com.girlscode.cafecomjava.core.Bebida;

public class XaropesDecorator extends ToppingDecorator {

    public XaropesDecorator(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return bebidaDecorada.getDescricao() + " + Xarope";
    }

    @Override
    public double getCusto() {
        return bebidaDecorada.getCusto() + 5.00;
    }
}
