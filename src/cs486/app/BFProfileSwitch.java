package cs486.app;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cs486.dataobjects.PlayerProfile;
import cs486.managers.BFManager;

public class BFProfileSwitch extends JFrame {
	
	private JLabel playersLabel;
	private JComboBox chooser;
	private JButton select, cancel;
	
	public BFProfileSwitch() {
		this.setMinimumSize(new Dimension(300, 200));
		this.setLayout(new FlowLayout());
		
		playersLabel = new JLabel("Choose a profile:");
		chooser = new JComboBox();
		for(PlayerProfile pp : BFManager.getInstance().getPlayers())
		{
			chooser.addItem(pp.getName());
		}
		
		select = new JButton("Switch");
		cancel = new JButton("Cancel");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BFManager.getInstance().setCurrentProfile(chooser.getSelectedIndex());
				((BFProfileSwitch) cancel.getRootPane().getParent()).dispose();
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((BFProfileSwitch) cancel.getRootPane().getParent()).dispose();
			}
		});
		
		this.add(playersLabel);
		this.add(chooser);
		
		this.add(select);
		this.add(cancel);
		
		this.setVisible(true);
	}
}
