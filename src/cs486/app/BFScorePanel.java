package cs486.app;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BFScorePanel extends JPanel {

	private final String PATH = "img/icon.gif";
	private JPanel profileInfo = new JPanel();
	
	public BFScorePanel() {
		this.setPreferredSize(new Dimension(200, 600));
		
		initProfileInfo();
		
		this.setVisible(true);
	}
	
	private void initProfileInfo() {
	    GridLayout grid = new GridLayout(1,2);
		profileInfo.setLayout(grid);
		BufferedImage sampleProfPic;
		try {
			//TODO get profile info from somewhere else
			sampleProfPic = ImageIO.read(new File(PATH));
			JLabel picLabel = new JLabel(new ImageIcon(sampleProfPic));
			picLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
			profileInfo.add(picLabel);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Failed to open profile picture");
		}
		this.add(profileInfo);
	}
}
