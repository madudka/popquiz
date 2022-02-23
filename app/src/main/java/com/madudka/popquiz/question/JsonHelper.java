package com.madudka.popquiz.question;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class JsonHelper {
    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try(InputStream is = context.getAssets().open(fileName)){
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

    public static ArrayList<Question> importFromJSON(String jsonString) {
        try {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Question>>(){}.getType();
            ArrayList<Question> questionLinkedList = new ArrayList<Question>(gson.fromJson(jsonString, collectionType));
            return questionLinkedList;
        } catch (Exception ex){
            return null;
        }

    }
}




