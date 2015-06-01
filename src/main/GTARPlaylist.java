package main;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GTARPlaylist {
	private Map<String,File> playlist;
	private File playlistDirectory;
	/**
	 * A GTARPlaylist is a standard playlist object used to hold filenames and their paths. Very shiny if I do so say myself.
	 * @param f the path to read from
	 * @return an object with a map representing a "Name -> path" representation.
	 */
	public GTARPlaylist(File directory) {
		playlistDirectory = directory;
		playlist = new HashMap<String,File>();
		
		//Lists subdirectories into an array, then maps the file Name to the Path in the playlist.
		String[] names = playlistDirectory.list();
		File f = new File("");
		for(String name : names){
			f=new File(playlistDirectory.toString()+"\\"+name);
			if(f.isFile())
				playlist.put(f.getName(),f);	
		}
	}
	/**
	 * A GTARPlaylist is a standard playlist object used to hold filenames and their paths. Very shiny if I do so say myself.
	 * @param filepath the path to read from
	 * @return an object with a map representing a "Name -> path" representation.
	 * 
	 * This simply passes along to the File f constructor
	 */
	public GTARPlaylist(String filepath){
		this(new File(System.getProperty("user.dir")+filepath));
	}

	public String toString(){
		return this.playlist.toString();
	}
	
	public String toStringf(int tabCount){
		String tabs = "";
		for(int i = 0; i<tabCount; i++)
			tabs+="\t";
		
		String output=tabs+playlistDirectory.getName()+":\n"+tabs+"Path: "+playlistDirectory.toString()+"\n";
		for(String f: this.playlist.keySet())
			output+=tabs+"-"+f+": "+this.playlist.get(f)+"\n";
		
		
		return output;
		
	}
}
