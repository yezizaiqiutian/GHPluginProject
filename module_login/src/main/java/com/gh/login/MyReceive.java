package com.gh.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.gh.core.proxyinterface.ProxyBroadCastInterface;

/**
 * @author: gh
 * @description:
 * @date: 8/7/21.
 * @from:
 */
public class MyReceive extends BroadcastReceiver implements ProxyBroadCastInterface {
    @Override
    public void attch(Context context) {
        // 广播绑定成功
        Toast.makeText(context,"广播绑定成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //接受到广播
        Toast.makeText(context," 接受到广播",Toast.LENGTH_LONG).show();
    }
}
