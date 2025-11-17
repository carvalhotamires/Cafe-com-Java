package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.CafeDescafeinado;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.ICafeFactory;

public class DescafeinadoFactory implements ICafeFactory {
    @Override
    public Bebida createBebida() {
        return new CafeDescafeinado();
    }
}
