package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

        private static Properties prop;

        public static Properties loadConfig() {

            try {
                FileInputStream fis =
                        new FileInputStream("src/test/resources/config.properties");
                prop = new Properties();
                prop.load(fis);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return prop;
        }

        public static String get(String key) {
            return loadConfig().getProperty(key);
        }
}


