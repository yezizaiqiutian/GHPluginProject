package com.gh.core.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gh.core.HookManager;
import com.gh.core.proxyinterface.ProxyBroadCastInterface;

import java.lang.reflect.Constructor;

/**
 * @author: gh
 * @description:
 * @date: 8/7/21.
 * @from:
 */
public class ProxyReceive extends BroadcastReceiver {
    String className;
    private ProxyBroadCastInterface receiveObj;

    public ProxyReceive(String className, Context context) {
        this.className = className;
        //这里通过classname 得到class对象，然后
        try {
            Class<?> receiverClass = HookManager.getInstance().getClassLoader().loadClass(className);
            Constructor constructorReceiver = receiverClass.getConstructor(new Class[]{});
            receiveObj = (ProxyBroadCastInterface) constructorReceiver.newInstance(new Object[]{});
            receiveObj.attch(context);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        receiveObj.onReceive(context, intent);
    }
}
