package main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class GTARConfigParser {
	private String path;
	/**
	 * Creates a new GTARConfigParser
	 * default path is Config/config.properties
	 */
	public GTARConfigParser(){
		this("Config/config.properties");
	}	
	/**
	 * Creates a new GTARConfigParser
	 * @param filePath the file this GTARConfigParser should read.
	 */
	public GTARConfigParser(String filePath){
		super();
		path =filePath;
	}
	
	/**
	 *returns a specified property in config.properties.
	 *this also is a wrapper for the try-catch statements so they aren't necessary each time you wish to read a property, mainly for code cleanup.
	 * @param property the name of the property you want to fetch
	 * @return the value of said property
	 */
	public String getPropValue(String property){
		try {
			return this.readPropValue(property);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	//actual property reading class
	private String readPropValue(String property) throws IOException {
		 
		String result = "";
		Properties prop = new Properties();

 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.path);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + this.path + "' not found in the classpath");
		}

		// get the property value and print it out
		result = prop.getProperty(property);
		inputStream.close();
		return result;
	}
	
	/**
	 * returns an ArrayList containing the names of all properties specified in config.properties
	 * @return all properties in config.properties
	 * @throws IOException 
	 */
	public ArrayList<String> getProperties(){
		ArrayList<String> returnList = new ArrayList<String>();
		try {
			returnList =  this.getPropertiesValues();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something broke");
			returnList.add("Broken");
		} 
		return returnList;
	}
	//actual getpropertiesvalues method
	private ArrayList<String> getPropertiesValues() throws IOException{
		Properties prop = new Properties();
 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.path);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + this.path + "' not found in the classpath");
		}
		ArrayList<String> list = new ArrayList<String>();
		for (Object k : prop.keySet()){
			list.add((String)k);
		}
		inputStream.close();
		return list;
	}
}
