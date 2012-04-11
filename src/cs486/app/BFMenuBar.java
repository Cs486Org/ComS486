package cs486.app;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class BFMenuBar extends JMenuBar {

	private JMenu fileMenu, profileMenu;
	private JMenuItem file_quit, profile_edit;
	
	public BFMenuBar() {
		file_quit = new JMenuItem("Quit");
		profile_edit = new JMenuItem("Edit");
		
		fileMenu = new JMenu("File");
		fileMenu.add(file_quit);
		
		profileMenu = new JMenu("Profile");
		profileMenu.add(profile_edit);
		
		this.add(fileMenu);
		this.add(profileMenu);
	}
}
