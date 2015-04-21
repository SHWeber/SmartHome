package com.smarthome.jw.smarthome.InputOutput;

import com.smarthome.jw.smarthome.Interfaces.InputOutput.HttpIOInterfae;

/**
 * Created by jonas on 22.04.15.
 */
public class HttpIO implements HttpIOInterfae {

    private String Network = "http://server:8083/fhem&cmd=%7BValue%28%22";
    private String getState = "%22%29%7D&XHR=1";

    public HttpIO()  {

    }
}
