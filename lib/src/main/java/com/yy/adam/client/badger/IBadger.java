package com.yy.adam.client.badger;

import android.content.Intent;

import com.yy.adam.remote.BadgerInfo;

/**
 * @author Lody
 */
public interface IBadger {

    String getAction();

    BadgerInfo handleBadger(Intent intent);

}
