package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.CafeExpresso;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.CafeFactory;

public class ExpressoFactory implements CafeFactory {
    @Override
    public Bebida createBebida() {
        return new CafeExpresso();
    }
}
