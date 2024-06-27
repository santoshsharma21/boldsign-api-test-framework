/**
 * 
 */
package com.boldsignapi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 */
public class ConfigReader {

	// init properties instance
	public static Properties pro;
	
	// method loads config file
	public void loadConfig() {
		File filePath = new File(System.getProperty("user.dir") + "/configurations/config.properties");
		try {
			FileInputStream fi = new FileInputStream(filePath);
			pro = new Properties();
			pro.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}