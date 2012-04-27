package cs486.app;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cs486.managers.BFManager;

public class BFProfileCreator extends JFrame {
	
	private JLabel nameLabel, phraseLabel;
	private JTextField nameField, phraseField;
	private JButton create, cancel;
	
	public BFProfileCreator() {
		this.setMinimumSize(new Dimension(300, 300));
		this.setLayout(new FlowLayout());
		
		nameLabel = new JLabel("User name:");
		phraseLabel = new JLabel("Catchphrase:");
		nameField = new JTextField();
		nameField.setColumns(20);
		phraseField = new JTextField(20);
		create = new JButton("Create");
		cancel = new JButton("Cancel");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BFManager.getInstance().createNewProfile(nameField.getText(), phraseField.getText());
				((BFProfileCreator) cancel.getRootPane().getParent()).dispose();
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((BFProfileCreator) cancel.getRootPane().getParent()).dispose();
			}
		});
		
		this.add(nameLabel);
		this.add(nameField);
		this.add(phraseLabel);
		this.add(phraseField);
		this.add(create);
		this.add(cancel);
		
		this.setVisible(true);
	}
}
