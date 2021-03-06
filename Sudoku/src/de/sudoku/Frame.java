package de.sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Frame extends JFrame implements Runnable, ActionListener, MouseListener
{
	
	private static final long serialVersionUID = 346124674397208574L;
	private final int CELLNUMBER = 9;
	protected static final byte CELLSIZE = 50;
	
	
	private Screen screen;
	private JButton solve, save, load;
	private Dialog dialog;
	private Cell[][] cells = new Cell[9][9];
	
	
	/**
	 * Loads the Frame and its components
	 */
	public Frame() {
		//Init Frame
		super("Sudoku Solver");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		
		
		//Init buttons
		solve = new JButton("Solve");
		solve.setBounds(CELLSIZE*CELLNUMBER+50, 50, 250, 40);
		solve.setBackground(Color.gray);
		solve.addActionListener(this);
		solve.setFocusable(false);
		this.add(solve);
		
		//Init JPanel aka Screen
		screen = new Screen();screen.addMouseListener(this);
		screen.setBounds(0, 0, CELLSIZE*CELLNUMBER+1 ,CELLSIZE*CELLNUMBER+1);
		screen.setBackground(Color.red);
		this.add(screen);
		
		//Init Dialog
		dialog = new Dialog(screen, CELLSIZE*CELLNUMBER); 
		
		//Init Cells
		for(int x = 0;x<cells.length;x++){
			for(int y = 0;y<cells.length;y++){
				cells[x][y] = new Cell(CELLSIZE);
			}
		}
		//Start frame thread
		new Thread(this).start();
	}
	
	/**
	 * Starts the thread for the frame
	 * Calls screen.repaint() in a loop
	 */
	@Override
	public void run(){
		while(true){
			screen.repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	/**
	 * 
	 * @author Dennis
	 * Represents the 9x9 sudoku field by a JPanel
	 */
	private class Screen extends JPanel{
		private static final long serialVersionUID = 7689830280226953237L;

		/**
		 * Paints the field
		 */
		@Override
		public void paint(Graphics g){
			super.paintComponent(g);
			//Look settings for the graphics2d object
			Graphics2D  g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			
			//Repaints each cell
			for(int x = 0;x<cells.length;x++){
				for(int y = 0;y<cells.length;y++){
					cells[x][y].paint(g2, x*CELLSIZE, y*CELLSIZE);;
				}
			}
			g2.setColor(Color.black);
			g2.drawLine(CELLSIZE*3-1, 0, CELLSIZE*3-1, CELLSIZE*9);
			g2.drawLine(CELLSIZE*6-1, 0, CELLSIZE*6-1, CELLSIZE*9);
			g2.drawLine(0, CELLSIZE*3-1, CELLSIZE*9, CELLSIZE*3-1);
			g2.drawLine(0, CELLSIZE*6-1, CELLSIZE*9, CELLSIZE*6-1);
			
		}
	}
	
	
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * Registrates where the user has clicked and opens an JDialog 
		 * to choose a number
		 * 
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			int x = (int) (e.getX()/CELLSIZE);
			int y = (int) (e.getY()/CELLSIZE);
			
			if(e.getX()<screen.getWidth() && e.getY() < screen.getHeight()&& e.getButton()==MouseEvent.BUTTON1){
				cells[x][y].greyOut();
				dialog.setLocationRelativeTo(screen);
				dialog.setVisible(true);
				cells[x][y].setValue(dialog.returnValue());
				cells[x][y].setNormalColor();
				
			}else if(e.getButton()==MouseEvent.BUTTON3) 
				cells[x][y].setValue((byte)  -1);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==solve){
			
		}
		else if(e.getSource()==save){
			
		}
	}
	
		
	
}
