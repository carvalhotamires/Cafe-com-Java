package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.ColdBrew;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.CafeFactory;

public class ColdBrewFactory implements CafeFactory {
    @Override
    public Bebida createBebida() {
        return new ColdBrew();
    }
}
