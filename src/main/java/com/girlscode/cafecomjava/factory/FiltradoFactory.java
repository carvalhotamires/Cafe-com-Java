package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.CafeFiltrado;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.CafeFactory;

public class FiltradoFactory implements CafeFactory {
    @Override
    public Bebida createBebida() {
        return new CafeFiltrado();
    }
}
