package cs486.app;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class BFMenuBar extends JMenuBar {

	private JMenu fileMenu, profileMenu;
	private JMenuItem file_quit, profile_edit;
	
	public BFMenuBar() {
		file_quit = new JMenuItem("Quit", KeyEvent.VK_Q);
		file_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Frame f : Frame.getFrames())
					f.dispose();
			}
		});
		profile_edit = new JMenuItem("Edit", KeyEvent.VK_E);
		
		fileMenu = new JMenu("File");
		fileMenu.add(file_quit);
		
		profileMenu = new JMenu("Profile");
		profileMenu.add(profile_edit);
		
		this.add(fileMenu);
		this.add(profileMenu);
	}
}
