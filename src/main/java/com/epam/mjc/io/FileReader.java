package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class FileReader {

    public Profile getDataFromFile(File file) {

//        String stringFile = "E:\\Autocode\\stage_1\\NIO\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt";
//        file = new File(stringFile);
        int b;

        java.io.FileReader fileReader = null;
        Map<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        try {
            fileReader = new java.io.FileReader(file);
            while ((b = fileReader.read()) != -1) {
                builder.append((char) b);
            }
            String[] words = builder.toString().split("\n");

            for(String w : words){
                String[] keyValue = w.split(": ");
                map.put(keyValue[0], keyValue[1].trim());
            }



        } catch (FileNotFoundException e) {
            System.err.println("File not found...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Profile profile = new Profile();
        profile.setName(map.get("Name"));
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setPhone(Long.parseLong(map.get("Phone")));

            return profile;
    }
}
