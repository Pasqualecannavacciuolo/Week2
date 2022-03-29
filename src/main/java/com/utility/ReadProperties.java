package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private static LOG L = null;
    public Properties properties;
    private InputStream inputStream;
    private String resourceName;
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public ReadProperties() {}

    /**
     * Constructor
     * @param properties
     * @param inputStream
     */
    public ReadProperties(Properties properties, InputStream inputStream) {
        this.properties = properties;
        this.inputStream = inputStream;
    }

    public void init() {
        this.L = LOG.getInstance();
        this.properties = new Properties();

    }


    public void read(String name) throws IOException {
        init();
        this.resourceName = name;
        inputStream = new FileInputStream("src/main/resources/" + this.resourceName);
        this.properties.load(inputStream);
    }

    public static void main(String[] args) {
        ReadProperties readProperties = new ReadProperties();

        try {

            readProperties.read("application.properties");
            String db_mysql_url = readProperties.properties.getProperty("db.mysql.url");
            String db_url = readProperties.properties.getProperty("db.url");
            String db_username = readProperties.properties.getProperty("db.username");
            String db_password = readProperties.properties.getProperty("db.password");

            L.info(db_mysql_url);
            L.info(db_url);
            L.info(db_username);
            L.info(db_password);

        } catch (IOException e) {
            e.printStackTrace();
            L.debug("Error");
        }
    }

}
