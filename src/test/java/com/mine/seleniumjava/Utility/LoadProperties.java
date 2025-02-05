package com.mine.seleniumjava.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	static LoadProperties instance; 
	private static final Object lock = new Object();
	static Properties prop = new Properties();
	private static String propertyFilePath = System.getProperty("user.dir") + "/config.properties"; 
	 
	public static String mainURL; 
	public static String driverPath; 
	public static String headless; 
	public static String gridHost; 
	public static String runMode; 
	
	//Create a Singleton instance. We need only one instance of Property Manager.
    public static LoadProperties getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new LoadProperties();
                instance.loadData();
            }
        }
        return instance;
    }
    
  //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        //Get properties from configuration.properties
        mainURL = prop.getProperty("mainURL");
        driverPath = prop.getProperty("driverPath");
        headless = prop.getProperty("headless");
        gridHost = prop.getProperty("gridHost"); 
        runMode = prop.getProperty("runMode"); 
    }

	public String getMainURL() {
		return mainURL;
	}

	public String getDriverPath() {
		return driverPath;
	}
    
	public String getHeadless() {
		return headless;
	}
	
	public String getGridHost() {
		return gridHost;
	}
	
	public String getRunMode() {
		return runMode;
	}
}
