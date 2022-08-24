package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class FileReader {

    public Profile getDataFromFile(File file) {

        int b;

        Map<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        try (java.io.FileReader fileReader = new java.io.FileReader(file)){
            while ((b = fileReader.read()) != -1) {
                builder.append((char) b);
            }
            String[] words = builder.toString().split("\n");

            for (String w : words) {
                String[] keyValue = w.split(": ");
                map.put(keyValue[0], keyValue[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Profile profile = new Profile();
        profile.setName(map.get("Name"));
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setPhone(Long.parseLong(map.get("Phone")));

        return profile;
    }
}
