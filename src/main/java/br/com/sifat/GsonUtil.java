package br.com.sifat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static String toJson(Object o) {
        return gson.toJson(o);

    }


}
