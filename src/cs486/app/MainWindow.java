package cs486.app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private int X_POS = 100, Y_POS = 100;
	private int WIDTH = 800, HEIGHT = 600;
	private BFGamePanel gamePane;
	private BFScorePanel scorePane;
	private BFMenuBar menuBar;
	
	public static void main(String... args) {
		MainWindow frame = new MainWindow();
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
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
				gamePane.setVisibleGame(1);
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
}
