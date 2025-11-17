package com.girlscode.cafecomjava.factory;

import com.girlscode.cafecomjava.bebidas.ColdBrew;
import com.girlscode.cafecomjava.core.Bebida;
import com.girlscode.cafecomjava.core.ICafeFactory;

public class ColdBrewFactory implements ICafeFactory {
    @Override
    public Bebida createBebida() {
        return new ColdBrew();
    }
}
