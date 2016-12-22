package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by madja_000 on 27.11.2016.
 */
public class PropertiesManager {

    private Properties property;

    private PropertiesManager() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        property = new Properties();
        try {
            property.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final PropertiesManager INSTANCE = new PropertiesManager();

    public static PropertiesManager getInstance(){
        return INSTANCE;
    }
    public String getResourceByName(String name){
        return property.getProperty(name);
    }
}
