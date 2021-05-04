package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_Demo;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projpath = System.getProperty("user.dir");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
		getProperties();

	}

	public static void getProperties() {


		try {
			String projpath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projpath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			//TestNG_Demo.browser = browser;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void setProperties() {

		try {
			OutputStream output = new FileOutputStream(projpath+"/src/test/java/config/config.properties");
			prop.setProperty("browser", "Chrome");
			prop.store(output, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
