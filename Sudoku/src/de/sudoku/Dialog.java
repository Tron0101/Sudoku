package de.sudoku;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Dialog extends JDialog implements KeyListener{
	
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
		this.addKeyListener(this);
		this.setUndecorated(true);	// hide and show problem
	}
	
	/**
	 * Initializes the buttons for the menu.
	 * Adds ActionListener to each button and adds them to the dialog
	 */
	private void init(){
		for(int i = 0; i<buttons.length;i++){
			buttons[i] = new JButton(Integer.toString(i+1));
			buttons[i].setBackground(Color.GRAY);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					val = (Byte.parseByte(((AbstractButton) e.getSource()).getText()));
					setVisible(false);	//Closes the dialog after a click
				}
				
			});
			this.add(buttons[i]);
			
		}
	}
	
	public void blockNumbers(byte[] numbers){
		for(int i = 0;i<numbers.length;i++){
			buttons[numbers[i]].setEnabled(false);
		}
	}
	
	public void resetButtons(){
		for(int i = 0;i<buttons.length;i++){
			buttons[i].setEnabled(true);
		}
				
	}
	
	/**
	 * 
	 * @return Returns the value of the clicked button
	 */
	public byte returnValue(){
		return val;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) this.dispose();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
