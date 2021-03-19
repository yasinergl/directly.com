package com.directly.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	private static Properties configFile;

	static {
		String path = "src/test/resources/configuration.properties";
		try {
			FileInputStream input = new FileInputStream(path);

			configFile = new Properties();
			configFile.load(input);

			input.close();
		} catch (Exception e) {
			System.out.println("path="+path);
			e.printStackTrace();

		}
	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
}