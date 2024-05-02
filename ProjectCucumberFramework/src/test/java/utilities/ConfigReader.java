package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /**
     * This class reads the Configuration.properties file.
     * The method getProperty(String key); fetches the
     * values from properties file using the key that is
     * provided as a parameter.
     *
     */
    private static FileInputStream input;
    private static Properties properties;
    static {
        String path = "C:\\Users\\hassa\\IdeaProjects\\ProjectCucumberFramework\\src\\test\\resources\\configurations\\configurations.properties";
        try {
            input = new FileInputStream(path);

            properties = new Properties();

            properties.load(input);

        } catch (FileNotFoundException e) {
            System.out.println("Path for properties file is invalid");
        } catch (IOException e) {
            System.out.println("Failed to load properties file");
        }finally {
            try{
                assert input != null;
                input.close();
            }catch (IOException e) {
                System.out.println("Exception occurred when trying to close the input object");
            }
        }
    }
    /**
     * This method accepts the key as String
     * and returns the value as String.
     * They keys and values are stored in the properties file
     */
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
