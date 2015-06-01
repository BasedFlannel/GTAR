package main;

import java.io.File;
import java.util.ArrayList;

public class GTARGame {
	private String name;
	private File gameDirectory;
	private ArrayList<GTARPlaylist> playlistRegistry;
	public GTARGame(File filepath){
		name=filepath.getName();
		gameDirectory = filepath;
		playlistRegistry = new ArrayList<GTARPlaylist>();
		
		//Lists subdirectories into an array, then makes a new Playlist of each and puts it in the registry.
		String[] names = gameDirectory.list();
		File f = new File("");
		for(String name : names){
			f=new File(gameDirectory.toString()+"\\"+name);
			if(f.isDirectory())
				playlistRegistry.add(new GTARPlaylist(f));	
		}
	}
	public String getName(){
		return this.name;
	}
	public String toStringf(){
		String output="\t"+name+":\n\n";
		for(GTARPlaylist g : playlistRegistry)
			output+="\t"+g.toStringf(1)+"\n";
		
		return output+"\t--------------------------\n";
	}
}
