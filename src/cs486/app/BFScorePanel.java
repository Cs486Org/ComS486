package cs486.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.border.Border;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class BFScorePanel extends JPanel {

	private final String PATH = "img/icon.gif";
	private JPanel profileInfo = new JPanel();
	
	public BFScorePanel() {
		this.setPreferredSize(new Dimension(200, 600));
		
		initProfileInfo();
		initScores();
		
		this.setVisible(true);
	}
	
	private void initScores() {
		// TODO Auto-generated method stub
		
	}

	private void initProfileInfo() {
	    GridLayout grid = new GridLayout(1,2);
		profileInfo.setLayout(grid);
		profileInfo.setPreferredSize(new Dimension(200, 80));
		BufferedImage sampleProfPic;
		//TODO get profile info from somewhere else
		//sampleProfPic = ImageIO.read(new File(PATH));
		//JLabel picLabel = new JLabel(new ImageIcon(sampleProfPic));
		//Border border = new LineBorder(Color.GRAY, 2, true);
		//Border margin = new EmptyBorder(2, 2, 2, 2);
		//picLabel.setBorder(new CompoundBorder(border, margin));
		//picLabel.setPreferredSize(new Dimension(50, 80));
		//TODO make a namecard class
		//TODO player.getName()
		JLabel nameCard = new JLabel("Chad");
		
		nameCard.setPreferredSize(new Dimension(150, 80));
		
		//profileInfo.add(picLabel);
		profileInfo.add(nameCard);
		this.add(profileInfo);
	}
}
