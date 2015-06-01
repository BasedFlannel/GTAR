package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class GTARConfigParser {
	private File path;
	/**
	 * Creates a new GTARConfigParser
	 * default path is Config/config.properties
	 */
	public GTARConfigParser(){
		this("\\config\\config.properties");
	}	
	/**
	 * Creates a new GTARConfigParser
	 * @param filePath the file this GTARConfigParser should read.
	 */
	public GTARConfigParser(String filePath){
		path = new File(System.getProperty("user.dir")+filePath);
		if(!path.isFile())
			try {
				System.out.println(path.toString() + " does not exist, creating.");
				String pathString = this.path.toString();
				File prefile = new File(pathString.substring(0,pathString.lastIndexOf('\\')));
				if(prefile.toString()!="")
					prefile.mkdirs();
				path.createNewFile();
			} catch (IOException e) {
				System.out.println("creation of "+path.toString()+" failed.");
				e.printStackTrace();
			}
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

 
		BufferedReader inputReader = new BufferedReader(new FileReader(this.path));
		prop.load(inputReader);

		// get the property value and print it out
		result = prop.getProperty(property);
		inputReader.close();
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
		
		BufferedReader inputReader = new BufferedReader(new FileReader(this.path));
		prop.load(inputReader);
		
		ArrayList<String> list = new ArrayList<String>();
		for (Object k : prop.keySet()){
			list.add((String)k);
		}
		inputReader.close();
		return list;
	}
}
