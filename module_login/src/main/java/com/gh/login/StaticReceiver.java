package com.gh.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author: gh
 * @description:
 * @date: 8/7/21.
 * @from:
 */
public class StaticReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "我是插件   收到宿主的消息  静态注册的广播  收到宿主的消息----->", Toast.LENGTH_SHORT).show();
        context.sendBroadcast(new Intent("com.gh.app.receiver.plugintoapp"));
    }
}
