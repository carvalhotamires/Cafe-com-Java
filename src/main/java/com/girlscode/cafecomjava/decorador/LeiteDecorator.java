package com.girlscode.cafecomjava.decorador;

import com.girlscode.cafecomjava.core.Bebida;

public class LeiteDecorator extends ToppingDecorator{

    public LeiteDecorator(Bebida bebidaDecorada) {
        super(bebidaDecorada);
    }

    @Override
    public String getDescricao() {
        return bebidaDecorada.getDescricao() + " com Leite";
    }

    @Override
    public double getCusto() {
        return bebidaDecorada.getCusto() + 2.50;
    }
}
