package main;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GTARFrame extends JFrame {
	private static final long serialVersionUID = 7736399725583414552L;
	/**
	 * This is the primary panel the entire GUI is based off of.
	 */
	public GTARFrame(){
		super();
		
		/**Content Panel and GridBag*/
		//homePanel is the default content panel
		JPanel homePanel = new JPanel(new GridBagLayout());
		this.setContentPane(homePanel);
		//gbc is the GridBag constraints, used for layout in GridBag.
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		/**Menu Bar*/
		//Menu Bar and top-level submenu declarations
		JMenuBar menuBar = new JMenuBar();
		populateMenuBar(menuBar);
		this.setJMenuBar(menuBar);
		/**Labels*/
		JLabel lblSelectPlaylist = new JLabel("Select Playlist");
		JLabel lblPlaylistContents = new JLabel("Playlist Contents");
		JLabel lblInfo = new JLabel("Info");
		
		/**Buttons*/
		JButton btnAddPlaylist = new JButton("Add Playlist");
		
		/**JLists*/
		JList listPlaylists = new JList();
		
		JList listContent = new JList();
		JList listInfo = new JList();
		
		//List Action Listeners
		listPlaylists.addListSelectionListener(new ListSelectionListener(){
			//Playlist List Action Listener
			public void valueChanged(ListSelectionEvent arg0) {
				//On value change, make the text in the 
				
			}
			
		});
		/**Finally adding GUI elements to the Frame*/
		//GBC constraints for getting all the UI in place.
		gbc.insets = new Insets(3,3,0,3);
		gbc.gridx = 1;
		gbc.weightx=1.0;
		gbc.weighty=0.0;
		this.add(lblSelectPlaylist, gbc);
		gbc.gridx=2;
		this.add(lblPlaylistContents, gbc);
		gbc.gridx=3;
		this.add(lblInfo, gbc);
		gbc.insets = new Insets(0,3,3,3);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.weighty=1;
		gbc.gridheight=2;
		this.add(listPlaylists, gbc);
		gbc.gridx=2;
		this.add(listContent, gbc);
		gbc.gridx=3;
		this.add(listInfo, gbc);
		gbc.gridx=0;
		gbc.weightx=0;
		gbc.weighty=0;
		gbc.gridheight=1;
		//will add a panel instead of raw buttons later.
		this.add(btnAddPlaylist, gbc);
		
		//muggling about 
		//EOJ JPanel tasks
		this.setBounds(50, 50, 900, 700);
		this.setVisible(true);
	}
	/**
	 * Method to populate the Menu Bar with Menus and items. Used to save space in the constructor.
	 * @param menuBar The Menu Bar to alter
	 */
	private void populateMenuBar(JMenuBar menuBar){
		//Menu declarations
		JMenu menuFiles = new JMenu("File");
		JMenu menuOptions = new JMenu("Options");
		JMenu menuGames = new JMenu("Game");
		
		//Files Menu Items declaration
		JMenuItem menuFilesRescanItem = new JMenuItem("Rescan for playlists");
		
		//Options Menu Items declaration
		JMenuItem menuOptionsResetItem = new JMenuItem("ResetAll");
		
		//Games Menu Items declaration
		JMenuItem menuGamesGameSwitchItem = new JMenu("Switch");
		/**/JRadioButtonMenuItem game;
		/**/ButtonGroup switchGameBtnGroup = new ButtonGroup();
		GTARMenuItem menuGamesAddGameItem = new GTARMenuItem("Add Game");
		
		/**
		 * Will eventually be replaced with code to read a file full of destination paths, and load those into the games Menu.
		 */
		ArrayList<String> tempGames = new ArrayList<String>();
		tempGames.add("g1");
		tempGames.add("g2");
		tempGames.add("g3");
		tempGames.add("g4");
		tempGames.add("g5");
		tempGames.add("g6");
		for(String str:tempGames){
			game = new JRadioButtonMenuItem(str);
			switchGameBtnGroup.add(game);
			menuGamesGameSwitchItem.add(game);
		}
		
		//now for the work
		//Constructing the menu bar up top
		//start with adding submenus to menus
		menuFiles.add(menuFilesRescanItem);
		menuOptions.add(menuOptionsResetItem);
		menuGames.add(menuGamesGameSwitchItem);
		menuGames.add(menuGamesAddGameItem);
		
		//add items to menu bar
		menuBar.add(menuFiles);
		menuBar.add(menuOptions);
		menuBar.add(menuGames);
	}
	/**
	 * Resets GridBagConstraints Parameters to defaults or something.
	 * @param gbc The GridBagConstraints to reset
	 */
	private void resetGBC(GridBagConstraints gbc){
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.ipadx=0;
		gbc.ipady=0;
		gbc.anchor=gbc.CENTER;
	}
}
