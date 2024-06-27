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
	private static Properties pro;

	// method return api key
	public static String getApiKey() {
		File filePath = new File(System.getProperty("user.dir") + "/configurations/config.properties");
		try {
			FileInputStream fi = new FileInputStream(filePath);
			pro = new Properties();
			pro.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pro.getProperty("api_key");
	}
}