package com.smarthome.jw.smarthome.InputOutput;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.smarthome.jw.smarthome.Interfaces.HttpIOInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jonas on 22.04.15.
 */
public class HttpIO implements HttpIOInterface {

    private String Network = "http://server:8083/fhem&cmd=%7BValue%28%22";
    private String getState = "%22%29%7D&XHR=1";

    Context context;

    public HttpIO()  {




    }



    @Override

    public boolean isNetworkAvailable() {

       /** ConnectivityManager cm = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }*/
        return false;
    }


    @Override
    public InputStream readLink(String link) throws IOException {

        URL obj = new URL(Network+link+getState);
        URLConnection con = obj.openConnection();
        return  con.getInputStream();





/**
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        int i = 0;
        boolean isContent = false;

        while ((inputLine = in.readLine()) != null) {


            if (inputLine.equalsIgnoreCase("<pre class=\"log\">")) {
                isContent= true;
                inputLine = in.readLine();
            } else  if (inputLine.equalsIgnoreCase("</pre></div></body></html>")) {
                isContent =false;
            }

            if (isContent) {
                System.out.println(inputLine);
            }

            i++;
        }
        in.close();
*/

    }

    @Override
    public OutputStream writeLink(String link) throws IOException {
        return null;
    }

    @Override
    public SharedPreferences getSharedPref() {
        return null;
    }
}
