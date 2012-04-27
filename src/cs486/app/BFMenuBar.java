package cs486.app;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.stream.XMLStreamException;

import cs486.managers.BFManager;

@SuppressWarnings("serial")
public class BFMenuBar extends JMenuBar {

	private JMenu fileMenu, profileMenu, file_game;
	private JMenuItem file_quit, file_save, file_save_and_quit, profile_new,
			profile_edit, profile_switch;
	private JMenuItem game1;

	public BFMenuBar() {
		file_quit = new JMenuItem("Quit", KeyEvent.VK_Q);
		file_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Frame f : Frame.getFrames())
					f.dispose();
			}
		});

		file_save = new JMenuItem("Save Profiles", KeyEvent.VK_S);
		file_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BFManager.getInstance().savePlayers();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (XMLStreamException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		file_save_and_quit = new JMenuItem("Save and Quit", KeyEvent.VK_V);
		file_save_and_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BFManager.getInstance().savePlayers();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (XMLStreamException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Frame f : Frame.getFrames())
					f.dispose();
			}
		});

		profile_switch = new JMenuItem("Switch", KeyEvent.VK_W);
		profile_switch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BFProfileSwitch();
			}
		});
						
		profile_edit = new JMenuItem("Edit", KeyEvent.VK_E);

		file_game = new JMenu("Choose Game...");
		game1 = new JMenuItem("Simon", KeyEvent.VK_S);
		game1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BFManager.getInstance().switchToGame(1);
			}
		});
		file_game.add(game1);

		profile_new = new JMenuItem("New", KeyEvent.VK_N);
		profile_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BFProfileCreator();
			}
		});

		fileMenu = new JMenu("File");
		fileMenu.add(file_save);
		fileMenu.addSeparator();
		fileMenu.add(file_game);
		fileMenu.addSeparator();
		fileMenu.add(file_quit);

		profileMenu = new JMenu("Profile");
		profileMenu.add(profile_new);
		profileMenu.addSeparator();
		profileMenu.add(profile_edit);
		profileMenu.add(profile_switch);

		this.add(fileMenu);
		this.add(profileMenu);
	}
}
