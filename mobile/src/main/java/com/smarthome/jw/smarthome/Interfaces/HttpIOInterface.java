package com.smarthome.jw.smarthome.Interfaces;

import android.content.SharedPreferences;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jonas on 22.04.15.
 */
public interface HttpIOInterface {

    public InputStream readLink(String link) throws IOException;

    public OutputStream writeLink(String link) throws IOException;

    public boolean isNetworkAvailable();



    public SharedPreferences getSharedPref();
}
