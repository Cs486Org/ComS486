package cs486.games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;


public class BFClickGame extends BFGame {

	private int score;
	private int lastScore;
	
	public BFClickGame() {
		super();
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void play() {
		for(int i = 0; i < 4; i++) {
			Point origin = drawCircle();
			
			listenForClick(origin);
		}
	}

	private void listenForClick(Point origin) {
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reportScore() {
		// TODO Auto-generated method stub

	}
	
	private Point drawCircle() {
		Graphics g = this.getGraphics();
		Random r = new Random();
		
		int radius = r.nextInt(25) + 5;
		int posX = r.nextInt(600 - radius) + radius;
		int posY = r.nextInt(600 - radius) + radius;
		
		g.setColor(Color.RED);
		g.fillOval(posX, posY, radius*2, radius*2);
		g.finalize();
		
		return new Point(posX, posY);
	}

}
