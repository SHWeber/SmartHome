package com.smarthome.jw.smarthome.InputOutput;

import android.os.AsyncTask;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Interfaces.AsyncResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jonas on 26.04.15.
 */
public class HttpTask extends AsyncTask <Gerät, Gerät, String> {

    private String Network = "http://server:8083/fhem&cmd=%7BValue%28%22";
    private String getState = "%22%29%7D&XHR=1";

    public AsyncResponse asyncResponse = null;

    public HttpTask(AsyncResponse asyncResponse) {
        super();

        this.asyncResponse = asyncResponse;
    }

    @Override
        protected String doInBackground(Gerät... params) {

            String response = "";


                try {
                    URL url = new URL(Network+params[0].getName()+getState);
                    URLConnection urlConnection = url.openConnection();

                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                    String s = "";
                    while ((s = in.readLine()) != null) {
                        response += s;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            return response;
        }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(asyncResponse != null) {
            asyncResponse.processFinish(s);
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
