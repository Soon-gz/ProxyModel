package com.abings.proxymodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.abings.proxymodel.Proxy.PersonC;
import com.abings.proxymodel.Proxy.ProxyPersonB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonC personC = new PersonC("小红");
        ProxyPersonB proxyPersonB = new ProxyPersonB(personC,this);

        //B代理A追求C小姐
        proxyPersonB.giveFloors();
        proxyPersonB.giveDolls();
        proxyPersonB.giveLove();
    }
}
