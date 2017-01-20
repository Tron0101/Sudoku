package de.sudoku;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Dialog extends JDialog{
	
	private static final long serialVersionUID = -4420611194056842395L;
	private JButton[] buttons = new JButton[9];
	private byte val = -1;
	
	/**
	 * Builds the JDialog relative to a component 
	 * @param c Mother-component
	 * @param size Size of the mother-component to scale
	 */
	public Dialog(Component c, int size){
		this.setSize(size/2, size/2);
		this.setModal(true);
		this.setLocationRelativeTo(c);
		this.setLayout(new GridLayout(3,3));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	
	/**
	 * Initializes the buttons for the menu.
	 * Adds ActionListener to each button and adds them to the dialog
	 */
	private void init(){
		for(int i = 0; i<buttons.length;i++){
			buttons[i] = new JButton(Integer.toString(i+1));
			buttons[i].setBackground(Color.gray);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
			buttons[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					val = (Byte.parseByte(((AbstractButton) e.getSource()).getText()));
					dispose();	//Closes the dialog after a click
				}
				
			});
			this.add(buttons[i]);
			
		}
	}
	
	/**
	 * 
	 * @return Returns the value of the clicked button
	 */
	public byte returnValue(){
		return val;
	}
}
