package com.abings.proxymodel.Proxy;

import android.content.Context;

/**
 * Created by Shuwen on 2016/8/31.
 */
public class ProxyPersonB implements GiftSubject {
    private RealSubjectPersonA realSubjectPersonA;
    public ProxyPersonB(PersonC personC,Context context){
        if (realSubjectPersonA == null){
            realSubjectPersonA = new RealSubjectPersonA(personC.getName(),context);
        }
    }

    @Override
    public void giveFloors() {
        realSubjectPersonA.giveFloors();
    }

    @Override
    public void giveDolls() {
        realSubjectPersonA.giveDolls();
    }

    @Override
    public void giveLove() {
        realSubjectPersonA.giveLove();
    }
}
