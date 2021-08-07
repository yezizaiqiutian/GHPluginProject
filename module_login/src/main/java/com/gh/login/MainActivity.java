package com.gh.login;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.gh.core.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_tosecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(that, SecondActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_registbroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intent = new IntentFilter();
                intent.addAction("com.gh.app.receiver.plugintoplugin");
                //调用register方法 肯定要调用宿主的 所以重写baseactivity
                registerReceiver(new MyReceive(), intent);
            }
        });

        findViewById(R.id.btn_sendbroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.gh.app.receiver.plugintoplugin");
                sendBroadcast(intent);
            }
        });

    }
}