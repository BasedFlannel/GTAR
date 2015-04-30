import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class GTARFrame extends JFrame {
	/**
	 * This is the primary panel the entire GUI is based off of.
	 */
	private static final long serialVersionUID = 7736399725583414552L;

	public GTARFrame(){
		super();
		/**
		 * Content Panel and GridBag
		 */
		//homePanel is the default content panel
		JPanel homePanel = new JPanel(new GridBagLayout());
		this.setContentPane(homePanel);
		//gbc is the GridBag constraints, used for layout in GridBag.
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		//Generic button to be used for multiple constructions later
		JButton button;
		/**
		 * Menu Bar
		 */
		//Menu Bar and top-level submenu declarations
		JMenuBar menuBar = new JMenuBar();
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
		 * delete this bit soon enough, filler for games menu.
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
		
		/*------------------------
		*add menu bar to gridbag |
		*-----------------------*/
		gbc.weightx = 1;
		gbc.gridwidth=3;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		homePanel.add(menuBar,gbc);
		
		/**
		 * buttons
		 */
		button = new JButton("Button 3");
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.gridwidth=2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipady = 40;
		homePanel.add(button, gbc);
		
		//EOJ JPanel tasks
		this.setBounds(50, 50, 300, 300);
		this.setVisible(true);
	}
}
