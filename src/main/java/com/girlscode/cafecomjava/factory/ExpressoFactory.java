package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.CafeExpresso;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.ICafeFactory;

public class ExpressoFactory implements ICafeFactory {
    @Override
    public Bebida createBebida() {
        return new CafeExpresso();
    }
}
