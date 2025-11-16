package com.girlscode.cafecomjava.decorador;

import com.girlscode.cafecomjava.core.Bebida;

public abstract class ToppingDecorator implements Bebida {
    protected  Bebida bebidaDecorada;

    public ToppingDecorator(Bebida bebidaDecorada) {
        this.bebidaDecorada = bebidaDecorada;
    }

    @Override
    public abstract String getDescricao();

    @Override
    public abstract double getCusto();
}
