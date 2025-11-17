package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.CafeFiltrado;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.ICafeFactory;

public class FiltradoFactory implements ICafeFactory {
    @Override
    public Bebida createBebida() {
        return new CafeFiltrado();
    }
}
