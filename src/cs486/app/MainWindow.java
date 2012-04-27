package cs486.app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private int X_POS = 100, Y_POS = 100;
	private int WIDTH = 800, HEIGHT = 600;
	private BFGamePanel gamePane;
	private BFScorePanel scorePane;
	private BFMenuBar menuBar;

	public MainWindow() {
		initializeBasicLayout();
		
		this.setVisible(true);
	}

	private void initializeBasicLayout() {
		this.setTitle("BrainFlex");
		this.setBounds(X_POS, Y_POS, WIDTH, HEIGHT);
	
		gamePane = new BFGamePanel();
		//TODO change this
		gamePane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//TODO something should probably happen here
			}
		});
		
		scorePane = new BFScorePanel();
		scorePane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		menuBar = new BFMenuBar();
		
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
		this.setJMenuBar(menuBar);
		this.add(gamePane);
		this.add(scorePane);
	}
	
	public void suggestGame(long runtime){
		gamePane.suggestGame(runtime);
	}

	public boolean isGameInPlay() {
		return gamePane.isGameInPlay(); 
	}
	
	public void displayGame(int id) {
		gamePane.setVisibleGame(id);
	}

	public void updateScorePanelWithNewProfile() {
		scorePane.updateProfileInfo();		
	}

	public void alertScore(int higherOrLower) {
		if(higherOrLower > 0)
			JOptionPane.showMessageDialog(this, "You set a new high score!  Congratulations!");
		else
			JOptionPane.showMessageDialog(this, "Your score has decreased significantly.  Consider a medical consultation.");
		
	}
}
