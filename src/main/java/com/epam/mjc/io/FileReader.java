package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (java.io.FileReader reader = new java.io.FileReader(file)) {
            Map<String, String> map = new HashMap<>();
            char[] chars = new char[1024];
            reader.read(chars);
            String inputString = new String(chars);
            String[] lines = inputString.split("\n");

            for (String line : lines) {
                String[] keyValue = line.split(": ");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    map.put(key, value);
                }
            }
            profile.setName(map.get("Name"));
            profile.setAge(Integer.parseInt(map.get("Age")));
            profile.setEmail(map.get("Email"));
            profile.setPhone(Long.parseLong(map.get("Phone")));
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return profile;
    }
}
