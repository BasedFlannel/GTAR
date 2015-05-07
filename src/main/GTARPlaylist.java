package main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class GTARPlaylist {
	Map<String,String> playlist;
	/**
	 * A GTARPlaylist is a standard playlist object used to hold filenames and their paths. Very shiny if I do so say myself.
	 * @param filepath the path to read from
	 * @return an object with a map representing a "Name -> path" representation.
	 */
	public GTARPlaylist(String filepath){
		playlist = new HashMap<String,String>(50);
		filepath = System.getProperty("user.dir")+filepath;
		try {
			Files.walk(Paths.get(filepath)).forEach(filePath -> {
			    if (Files.isRegularFile(filePath)) {
			        System.out.println(filePath);
			    }
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Filepath invalid: filepath " + filepath + " does not exist");
		}
	}
}
