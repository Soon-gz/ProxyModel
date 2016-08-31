package com.abings.proxymodel.Proxy;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Shuwen on 2016/8/31.
 */
public class RealSubjectPersonA implements GiftSubject {

    private String name;
    private Context context;
    public RealSubjectPersonA(String name,Context context){
        this.name = name;
        this.context = context;
    }

    @Override
    public void giveFloors() {
        Toast.makeText(context, "A先生送"+name+"小姐一束花。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void giveDolls() {
        Toast.makeText(context, "A先生送"+name+"小姐一个玩具熊。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void giveLove() {
        Toast.makeText(context, "A先生向"+name+"小姐表达爱意。", Toast.LENGTH_SHORT).show();
    }
}
