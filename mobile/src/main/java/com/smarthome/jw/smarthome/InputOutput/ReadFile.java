package com.smarthome.jw.smarthome.InputOutput;

import android.content.Context;

import com.smarthome.jw.smarthome.Devices.DimLicht;
import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Devices.Heizung;
import com.smarthome.jw.smarthome.Devices.Kontakt;
import com.smarthome.jw.smarthome.Devices.Licht;
import com.smarthome.jw.smarthome.Devices.Media;
import com.smarthome.jw.smarthome.Devices.RGBLicht;
import com.smarthome.jw.smarthome.Devices.Rollo;
import com.smarthome.jw.smarthome.Devices.Steckdose;
import com.smarthome.jw.smarthome.Devices.TV;
import com.smarthome.jw.smarthome.Home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by jonas on 01.05.15.
 */
public class ReadFile {

    private FileIO fileIO;
    private Context context;

    public ReadFile(Context context) {

        fileIO = new FileIO(context);
        this.context = context;



    }

    public ArrayList<Gerät> Read() {

        ArrayList<String> StringList = new ArrayList<String>();
        ArrayList<Gerät> GeräteListe = new ArrayList<Gerät>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIO.readAsset("Devices.txt")));
            String line = bufferedReader.readLine();

            for (int i = 0; line != null ; i++) {
                StringList.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String [] linesplit;
        for (int i = 0; i < StringList.size()-1 ; i++) {

            linesplit = StringList.get(i).split(",");
            switch (linesplit[0]) {
                case "Licht": GeräteListe.add(new Licht(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "Rollo": GeräteListe.add(new Rollo(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "Heizung": GeräteListe.add(new Heizung(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "DimLicht": GeräteListe.add(new DimLicht(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "RGBLicht": GeräteListe.add(new RGBLicht(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "Steckdose": GeräteListe.add(new Steckdose(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "Kontakt": GeräteListe.add(new Kontakt(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "Media": GeräteListe.add(new Media(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
                case "TV": GeräteListe.add(new TV(context,linesplit[0],linesplit[1],linesplit[2],linesplit[3]));
            }

        }



        return GeräteListe;
    }

    public ArrayList<Gerät> getRoomGeräte(String roomname) {

        ArrayList<String> StringList = new ArrayList<String>();
        ArrayList<Gerät> GeräteListe = new ArrayList<Gerät>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIO.readAsset("Devices.txt")));
            String line = bufferedReader.readLine();

            for (int i = 0; line != null ; i++) {
                StringList.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < StringList.size() ; i++) {
            String [] linesplit;
            linesplit = StringList.get(i).split(",");
            if(linesplit[2].equals(roomname)) {

                if(linesplit[0].equals("Licht")) {

                    GeräteListe.add(new Licht(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));

                }
                else if(linesplit[0].equals("Rollo")) {
                    GeräteListe.add(new Rollo(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }

                else if(linesplit[0].equals("Heizung")) {
                    GeräteListe.add(new Heizung(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }

                else if(linesplit[0].equals("TV")) {
                    GeräteListe.add(new TV(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }

                else if(linesplit[0].equals("Media")) {
                    GeräteListe.add(new Media(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }

                else if(linesplit[0].equals("Steckdose")) {
                    GeräteListe.add(new Steckdose(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }
                else if(linesplit[0].equals("DimLicht")) {
                    GeräteListe.add(new DimLicht(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }

                else if(linesplit[0].equals("Kontakt")) {
                    GeräteListe.add(new Kontakt(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }
                else if(linesplit[0].equals("RGBLicht")) {
                    GeräteListe.add(new RGBLicht(context, linesplit[0], linesplit[1], linesplit[2], linesplit[3]));
                }

                }

            }

        return GeräteListe;
    }


}
