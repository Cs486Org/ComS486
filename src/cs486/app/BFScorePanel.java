package cs486.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.border.Border;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;

import cs486.dataobjects.PlayerProfile;
import cs486.managers.BFManager;

@SuppressWarnings("serial")
public class BFScorePanel extends JPanel {

//	private final String PATH = "img/icon.gif";
//	private JPanel profileInfo;
	private JLabel name, phrase, score;
	
	public BFScorePanel() {
		this.setPreferredSize(new Dimension(200, 600));
		this.setLayout(new GridLayout(4, 1));
		
		name = new JLabel();
		name.setBorder(new EmptyBorder(10, 10, 10, 10));
		phrase = new JLabel();
		phrase.setBorder(new EmptyBorder(10, 10, 10, 10));
		score = new JLabel();
		score.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.add(name);
		this.add(phrase);
		this.add(score);
		JPanel padding = new JPanel();
		padding.setPreferredSize(new Dimension(200, 500));
		this.add(padding);
		
		updateProfileInfo();
		
		this.setVisible(true);
	}

	public void updateProfileInfo() {
		PlayerProfile p = BFManager.getInstance().getCurrentProfile();
				
		System.out.println(p.getName());
		
		name.setText(p.getName());
		phrase.setText(String.valueOf(p.getHighScore()));
		score.setText(p.getCatchphrase());
		
		this.validate();
	}
}
