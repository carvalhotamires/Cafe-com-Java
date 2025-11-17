package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.CafeDescafeinado;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.CafeFactory;

public class DescafeinadoFactory implements CafeFactory {
    @Override
    public Bebida createBebida() {
        return new CafeDescafeinado();
    }
}
