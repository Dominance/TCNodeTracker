package com.dyonovan.tcnodetracker.lib;

import com.dyonovan.tcnodetracker.TCNodeTracker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonUtils {

    public static void writeJson() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(TCNodeTracker.nodelist);

        try {
            FileWriter fw = new FileWriter(TCNodeTracker.hostName + "/nodes.json");
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readJson() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(TCNodeTracker.hostName + "/nodes.json"));
            Gson gson = new Gson();
            TCNodeTracker.nodelist = gson.fromJson(br, TCNodeTracker.nodelist.getClass());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}