package de.sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Frame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 346124674397208574L;
	private Screen screen;
	private Cell[][] cells = new Cell[9][9];
	public static final byte CELLSIZE = 50;
	private final int CELLNUMBER = 9;
	
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
		
		//Init JPanel aka Screen
		screen = new Screen();screen.addMouseListener(new Handler());
		screen.setBounds(0, 0, CELLSIZE*CELLNUMBER+1 ,CELLSIZE*CELLNUMBER+1);
		screen.setBackground(Color.red);
		this.add(screen);
		
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
		}
	}
	
	/**
	 * 
	 * @author Dennis
	 *	MouseListener for the Screen class
	 */
	private class Handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			if(e.getX()<screen.getWidth() && e.getY() < screen.getHeight()){
				int x = (int) (e.getX()/CELLSIZE);
				int y = (int) (e.getY()/CELLSIZE);
				Dialog d = new Dialog(screen, CELLSIZE*CELLNUMBER); //Unschoen
				cells[x][y].setValue(d.returnValue());
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
		
	
}
