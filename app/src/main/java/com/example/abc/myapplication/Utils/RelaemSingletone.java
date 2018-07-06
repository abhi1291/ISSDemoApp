package com.example.abc.myapplication.Utils;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;

public class RelaemSingletone {


    private final Realm realm;

    public RelaemSingletone() {
        realm = Realm.getDefaultInstance();
    }

    private static class LazyHolder {

        private static RelaemSingletone instance=new RelaemSingletone();

    }


    public static RelaemSingletone with() {


        return LazyHolder.instance;
    }



    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }

    //clear all objects from Book.class

}
