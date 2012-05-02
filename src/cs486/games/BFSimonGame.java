package cs486.games;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cs486.managers.BFManager;

public class BFSimonGame extends BFGame implements java.awt.event.ActionListener, Runnable{

	protected static Color[] buttonColors = {Color.RED, Color.BLUE , Color.GREEN, Color.YELLOW};
	//java.util.LinkedList<Integer> sequence;
	java.util.LinkedList<Integer> sequence;
	
	long startTime;
	int guessIndex; //the index of the sequence which needs to be guessed next.
	boolean playback;//indicates the game is playing back a 
	//java.util.LinkedList<javax.swing.JButton> buttons;
	java.util.LinkedList<SimonButton> buttons;
	
	
	
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.run();
	}

	protected void start(){
		
		sequence = new java.util.LinkedList<Integer>();
		startTime = System.currentTimeMillis();
		playback = true;
		initializeDisplay();
		addAndPlaySequence();

		
	}

	private void initializeDisplay() {
		this.setBackground(Color.WHITE);
		repaint();
		if(buttons == null){
			//buttons = new java.util.LinkedList<javax.swing.JButton>();
			buttons = new java.util.LinkedList<SimonButton>();
			for(int i = 0; i < 4 ; i++){
				//javax.swing.JButton newbutton = new javax.swing.JButton();
				SimonButton newButton = new SimonButton(this, buttonColors[i]);
				add(newButton);
				//newbutton.setActionCommand(Integer.toString(i));
				//newbutton.addActionListener(this);
				newButton.setPreferredSize(new java.awt.Dimension(200, 200));
				newButton.setLocation((i % 2) * 300, (i * 2) * 300);
			
				repaint();
				//newbutton.s
				//newbutton.setBackground(buttonColors[i]);
			
				buttons.add(newButton);
				
			}
			javax.swing.JButton newbutton= new javax.swing.JButton();
			newbutton.setActionCommand("Start");
			newbutton.addActionListener(this);
			newbutton.setPreferredSize(new java.awt.Dimension(250, 100));
			newbutton.setText("Start");
			newbutton.setLocation(450, 240);
			this.add(newbutton);
			//buttons.add(newbutton);
		}
		
		repaint(0);
		
	}
	
	private void addAndPlaySequence() {
		playback = true;
        sequence.add((int) (Math.floor(Math.random() * 4.0) % 4));
        for(SimonButton s : buttons){
			s.resetColor();
		}
//        System.out.println(sequence.size());
        for(int i = 0; i < sequence.size(); i++){
            int buttonNumber = sequence.get(i);
            buttons.get(buttonNumber).shadeButton();
            repaint(0);
            this.paintImmediately(getBounds());
//            try {
//				Thread.sleep(400);
//			} catch (InterruptedException e){}
            for(int x= 0; x < 6000000; x++){
            	repaint();
            }
            buttons.get(buttonNumber).resetColor();
            this.paintImmediately(getBounds());
            //buttons.get(buttonNumber).repaint(0);
            repaint();
            try {
            	Thread.sleep(100);
            } catch (InterruptedException e){}
        }
        //this
        guessIndex = 0;
		playback = false;
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
       if(sequence == null){
    	   BFManager.getInstance().newHighScore(0);
    	   //System.out.println(0);
       } else{
    	   BFManager.getInstance().newHighScore(sequence.size() - 1);
    	   //System.out.println(sequence.size() - 1);
       }
	}
	public void clickButton(SimonButton simonButton, Color buttonColor){
		//this.setBackground(buttonColor);
		if(playback || sequence.size()<=0) return;
		for (int i = 0; i < buttons.size(); i++){
		if(buttonColor.equals(buttonColors[i])){
			if(i == sequence.get(guessIndex)){
				guessIndex++;
				if(guessIndex >= sequence.size()){
					addAndPlaySequence();
				}
				//continue the current round
				//as in, do nothing right here, leave the loop
				return;
			}else{
				sequenceMismatch();
				return;
			}
		}
		}
	    addAndPlaySequence();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		start();
	}

	private void sequenceMismatch() {
		// TODO Auto-generated method stub
		reportScore();
		for(SimonButton s : buttons){
			s.setBackground(Color.BLACK);
		}
		//start();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		start();
	}
	/**
	 * I can't believe I'm doing this.
	 * @author jemonono
	 *
	 */
	protected class SimonButton extends javax.swing.JPanel implements MouseListener{
		public Color buttonColor;
		BFSimonGame game;
		
		public SimonButton(BFSimonGame game, Color color){
			buttonColor = color;
			this.addMouseListener(this);
			this.setBackground(buttonColor);
		    this.game = game;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			game.clickButton(this, buttonColor);
			
		}
		
		public void resetColor(){
			this.setBackground(buttonColor);
		}
		
		public void shadeButton(){
			//this.setBackground(buttonColor.brighter());
			this.setBackground(Color.BLACK);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			//do nothing
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			//do nothing
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			shadeButton();
			repaint();
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			resetColor();
			repaint();
			
			
		}
	}

}
