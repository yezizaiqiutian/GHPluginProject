package com.gh.ghpluginproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gh.core.HookManager;
import com.gh.core.proxy.ProxyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_loadplugin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPlugin();
            }
        });


        findViewById(R.id.btn_startplugin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProxy();
            }

        });
        findViewById(R.id.btn_sendbroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "我是宿主  插件插件!收到请回答!!  1", Toast.LENGTH_SHORT).show();
                Intent newintent = new Intent();
                newintent.setAction("com.gh.app.receiver.apptoplugin");
                sendBroadcast(newintent);
            }
        });
        registerReceiver(mReceiver, new IntentFilter("com.gh.app.receiver.plugintoapp"));

    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, " 我是宿主，收到你的消息,握手完成!", Toast.LENGTH_SHORT).show();
        }
    };

    private void loadPlugin() {
        HookManager.getInstance().loadPlugin(this, "modulelogin.apk");
    }

    private void startProxy() {
        Intent intent = new Intent(this, ProxyActivity.class);
        intent.putExtra("ClassName", HookManager.getInstance().packageInfo.activities[0].name);
        startActivity(intent);
    }
}