package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GTARGameRegistry {
	private ArrayList<GTARGame> gameRegistry;
	private int activeGame;
	public GTARGameRegistry(){
		gameRegistry=new ArrayList<GTARGame>();
		activeGame = 0;
		File filepath = new File(System.getProperty("user.dir")+"\\games");
		if(!filepath.exists()){
			System.out.println("Games directory doesn't exist, creating now.");
			filepath.mkdirs();
		}
		
		//Lists subdirectories into an array, then makes a new GTARGame of each and puts it in the registry.
		String[] names = filepath.list();
		File f = new File("");
		for(String name : names){
			f=new File(filepath.toString()+"\\"+name);
			if(f.isDirectory())
				gameRegistry.add(new GTARGame(f));	
		}
	}
	
	public ArrayList<GTARGame> getGames(){
		return this.gameRegistry;
	}
	
	public String toString(){
		String output = "GTAR Game Registry Contents\nActive Index: "+this.getActiveGameIndex()+"\n\n";
		for(GTARGame g:this.gameRegistry){
			output+=g.toStringf()+"\n";
		}
		return output;
	}
	
	public int count(){
		return this.gameRegistry.size();
	}
	
	public GTARGame getActiveGame(){
		return this.getGame(this.getActiveGameIndex());
	}
	
	public int getActiveGameIndex(){
		return this.activeGame;
	}
	
	public void setActiveGame(int index){
		if(this.gameRegistry.size()>index)
			this.activeGame=index;
		else
			System.out.println("incorrect nunmber\n Registry size: " + this.gameRegistry.size()+"\nRequested index: "+index+"\nActive game shall remain as "+this.activeGame);
	}

	public GTARGame getGame(int i) {
		try{
			return this.gameRegistry.get(i);
		}catch(Exception e){
			System.out.println("No game in index "+i);
			e.printStackTrace();
			return null;
		}
	}
}
