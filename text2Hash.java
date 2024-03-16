//program to read a text file and convert it into a hash map

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class text2Hash {

    
public static Map<String, String> readHexCodesFromFile(String filePath) 
{
    Map<String, String> map = new HashMap<>();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" = ");
            if (parts.length == 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            }
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("An error occurred while reading hex codes from file");
        e.printStackTrace();
    }
    return map;
    }
}


