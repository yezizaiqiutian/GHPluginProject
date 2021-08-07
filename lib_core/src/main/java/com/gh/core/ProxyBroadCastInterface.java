package com.gh.core;

import android.content.Context;
import android.content.Intent;

/**
 * @author: gh
 * @description:
 * @date: 8/7/21.
 * @from:
 */
public interface ProxyBroadCastInterface {

    void attch(Context context);

    void onReceive(Context context, Intent intent);
}