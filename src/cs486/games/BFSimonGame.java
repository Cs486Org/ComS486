package cs486.games;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class BFSimonGame extends BFGame implements java.awt.event.ActionListener, Runnable{

	protected static Color[] buttonColors = {Color.RED, Color.BLUE , Color.GREEN, Color.YELLOW};
	java.util.LinkedList<Integer> sequence;
	
	long startTime;
	int guessIndex; //the index of the sequence which needs to be guessed next.
	boolean playback;//indicates the game is playing back a 
	java.util.LinkedList<javax.swing.JButton> buttons;
	
	
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.run();
	}

	protected void start(){
		this.setBackground(Color.WHITE);
		repaint();
		sequence = new java.util.LinkedList<Integer>();
		startTime = System.currentTimeMillis();
		playback = true;
		if(buttons == null){
			buttons = new java.util.LinkedList<javax.swing.JButton>();
			for(int i = 0; i < 4 ; i++){
				javax.swing.JButton newbutton = new javax.swing.JButton();
				
				add(newbutton);
				newbutton.setActionCommand(Integer.toString(i));
				newbutton.addActionListener(this);
				newbutton.setPreferredSize(new java.awt.Dimension(200, 200));
				newbutton.setLocation((i % 2) * 400, (i * 2) * 400);
				repaint();
				//newbutton.s
				newbutton.setBackground(buttonColors[i]);
			
				buttons.add(new javax.swing.JButton());
				
			}
		}
		repaint(0);
		playback = true;
		//this.
//	    try{
//	    	Thread.sleep(2500);
//	    } catch (Exception e){}
		
	}
	
	private void addAndPlaySequence() {
		playback = true;
        sequence.add((int) (Math.floor(Math.random() * 4.0) % 4));
        for(int i = 0; i < sequence.size(); i++){
            int buttonNumber = sequence.get(i);
            buttons.get(buttonNumber).setBackground(Color.WHITE);
            repaint(0);
            try {
				Thread.sleep(400);
			} catch (InterruptedException e){}
            buttons.get(buttonNumber).setBackground(buttonColors[buttonNumber]);
            repaint();
            try {
            	Thread.sleep(100);
            } catch (InterruptedException e){}
        }
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
		// TODO Auto-generated method stub
       if(sequence != null){
    	   //return 0;
       } else{
    	   //return sequence.size() - 1;
       }
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(playback || sequence.size()<=0) return;
		for (int i = 0; i < buttons.size(); i++){
			if(Integer.toString(i).equals(arg0.getActionCommand())){
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

	private void sequenceMismatch() {
		// TODO Auto-generated method stub
		reportScore();
		start();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		start();
	}

}
