package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties readProperties(){
        Properties properties  = new Properties();
        Path path  = Paths.get("src/resources/database.properties");

        try(
                BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
        ){
            properties.load(bufferedReader);
            return properties;
        }catch (IOException ex ){
            System.out.println("Failed to load the properties file!!!");
            ex.printStackTrace();
            return null;
        }

    }
}
