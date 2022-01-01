package com.orangehrm_hybrid_framework.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public static Properties prop = null;

	public ConfigDataProvider(String configDataPath) {
		try {
			File fs = new File(configDataPath);
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);
		} catch (Exception e) {
			System.out.println("File not found:" + e.getMessage());
		}
	}

	public String getValue(String keyname) {
		return prop.getProperty(keyname);
	}

	public String getUsername() {
		return prop.getProperty("username");

	}

	public String getPwd() {
		return prop.getProperty("password");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}

}