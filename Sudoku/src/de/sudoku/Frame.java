package de.sudoku;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Frame implements Runnable{
	
	private JFrame f;
	private Screen screen;
	private Cell[][] cells = new Cell[9][9];
	private final byte CELLSIZE = 50;
	private final int CELLNUMBER = 9;
	
	public Frame() {
		f = new JFrame("Sudoku Solver");
		f.setSize(800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setResizable(false);
		screen = new Screen();screen.addMouseListener(new Handler());
		screen.setBounds(0, 0, CELLSIZE*CELLNUMBER+1 ,CELLSIZE*CELLNUMBER+1);
		screen.setBackground(Color.red);
		System.out.println(cells.length);
		f.add(screen);
		for(int x = 0;x<cells.length;x++){
			for(int y = 0;y<cells.length;y++){
				cells[x][y] = new Cell(CELLSIZE);
			}
		}
		new Thread(this).start();
	}
	
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
	
	public JFrame getFrame(){
		return f;
	}
	
	private class Screen extends JPanel{
		@Override
		public void paint(Graphics g){
			super.paintComponent(g);
			for(int x = 0;x<cells.length;x++){
				for(int y = 0;y<cells.length;y++){
					cells[x][y].paint(g, x*CELLSIZE, y*CELLSIZE);;
				}
			}
		}
	}
	
	private class Handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getX()<screen.getWidth() && e.getY() < screen.getHeight()){
				int x = (int) (e.getX()/CELLSIZE);
				int y = (int) (e.getY()/CELLSIZE);
				cells[x][y].setColor(Color.GREEN);
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
		
	
}
