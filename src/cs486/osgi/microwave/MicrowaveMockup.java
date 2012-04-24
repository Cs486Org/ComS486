package cs486.osgi.microwave;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MicrowaveMockup extends JFrame implements ThreadCompleteListener, ActionListener {

	private int X_POS = 100, Y_POS = 100;
	private int WIDTH = 256, HEIGHT = 512;
	private int cooktime = -1;
	private int setTime = -1;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b0;
	private JButton start;
	private JTextField textField;
	Timer clock;
	MicrowaveThread mt;
	

	
	public static void main(String... args) {
		MicrowaveMockup frame = new MicrowaveMockup();	
	}

	public MicrowaveMockup() {
		initializeBasicLayout();
		
		this.setVisible(true);
	}
	
	public int getCookingTime(){
		return this.cooktime;
	}

	private void initializeBasicLayout() {
		this.setTitle("BrainFlex");
		this.setBounds(X_POS, Y_POS, WIDTH, HEIGHT);
	
		//gamePane = new BFGamePanel();
		//scorePane = new BFScorePanel();
		//menuBar = new BFMenuBar();
		
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
		//this.setJMenuBar(menuBar);
		//this.add(gamePane);
		//this.add(scorePane);
		b1 = new JButton("1 Minute");
		b1.addActionListener(this);
		b1.setActionCommand("b1Push");
		b2 = new JButton("2 Minutes");
		b2.addActionListener(this);
		b2.setActionCommand("b2Push");
		b3 = new JButton("3 Minutes");
		b3.addActionListener(this);
		b3.setActionCommand("b3Push");
		b4 = new JButton("4 Minutes");
		b4.addActionListener(this);
		b4.setActionCommand("b4Push");
		b5 = new JButton("5 Minutes");
		b5.addActionListener(this);
		b5.setActionCommand("b5Push");
		b6 = new JButton("6 Minutes");
		b6.addActionListener(this);
		b6.setActionCommand("b6Push");
		b7 = new JButton("7 Minutes");
		b7.addActionListener(this);
		b7.setActionCommand("b7Push");
		b8 = new JButton("8 Minutes");
		b8.addActionListener(this);
		b8.setActionCommand("b8Push");
		b9 = new JButton("9 Minutes");
		b9.addActionListener(this);
		b9.setActionCommand("b9Push");
		b0 = new JButton("10 Minutes");
		b0.addActionListener(this);
		b0.setActionCommand("b0Push");
		start = new JButton("Start Button");
		start.addActionListener(this);
		start.setActionCommand("startButton");
		textField = new JTextField(20);
		textField.setEnabled(false);
		Container content = this.getContentPane();
	    content.setBackground(Color.white);
	    content.setLayout(new FlowLayout()); 
	    content.add(textField);
	    content.add(b1);
	    content.add(b2);
	    content.add(b3);
	    content.add(b4);
	    content.add(b5);
	    content.add(b6);
	    content.add(b7);
	    content.add(b8);
	    content.add(b9);
	    content.add(b0);
	    content.add(start);
	    clock = new Timer();
	    
	}
	
	public void actionPerformed(ActionEvent e) {
	    if("b1Push".equals(e.getActionCommand())){
	    	setTime = 60000*1;
	    	textField.setText("1 Minute");
	    }else if("b2Push".equals(e.getActionCommand())){
	    	setTime = 60000*2;
	    	textField.setText("2 Minutes");
	    }else if("b3Push".equals(e.getActionCommand())){
	    	setTime = 60000*3;
	    	textField.setText("3 Minutes");
	    }else if("b4Push".equals(e.getActionCommand())){
	    	setTime = 60000*4;
	    	textField.setText("4 Minutes");
	    }else if("b5Push".equals(e.getActionCommand())){
	    	setTime = 60000*5;
	    	textField.setText("5 Minutes");
	    }else if("b6Push".equals(e.getActionCommand())){
	    	setTime = 60000*6;
	    	textField.setText("6 Minutes");
	    }else if("b7Push".equals(e.getActionCommand())){
	    	setTime = 60000*7;
	    	textField.setText("7 Minutes");
	    }else if("b8Push".equals(e.getActionCommand())){
	    	setTime = 60000*8;
	    	textField.setText("8 Minutes");
	    }else if("b9Push".equals(e.getActionCommand())){
	    	setTime = 60000*9;
	    	textField.setText("9 Minutes");
	    }else if("b0Push".equals(e.getActionCommand())){
	    	setTime = 60000*10;
	    	textField.setText("10 Minutes");
	    }else if("startButton".equals(e.getActionCommand())){
	    	if(setTime > 0){
	    		textField.setText(textField.getText()+": Starting Cooking");
	    		this.cooktime = setTime;
	    		System.out.println("Microwave Starting.");
	    		mt = new MicrowaveThread(cooktime);
	    		mt.addListener(this);
	    		mt.start();
	    		
	    	}
	    }
	}

	@Override
	public void notifyOfThreadComplete(MicrowaveThread microwaveThread) {
		this.cooktime = -1;
		this.setTime = -1;
		textField.setText(textField.getText()+": Finished!");
		System.out.println("Microwave Stopped.");
		
	} 
}
