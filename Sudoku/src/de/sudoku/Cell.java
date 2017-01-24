package de.sudoku;

import java.awt.Color;
import java.awt.Graphics2D;


public class Cell {
	
	private byte value, size;
	private Color c = new Color(255, 0, 0);
	
	/**
	 * Initializes a cell
	 * @param size Size in pixels of a cell
	 */
	public Cell(byte size){
		this.size = size;
		value = -1;
	}
	
	/**
	 * Paints this cell
	 * @param g Graphics2D object of the Screen 
	 * @param x	x-coordinate of the cell
	 * @param y	y-coordinate of the cell
	 */
	public void paint(Graphics2D g, int x, int y){
		g.setColor(c);
		g.fillRect(x,  y, size, size);
		g.setColor(Color.black);
		g.drawRect(x,  y, size, size);
		if(value!=-1)	g.drawString(Byte.toString(value), x+Frame.CELLSIZE/2-10, y+Frame.CELLSIZE/2+15);
		
	}
	
	//Setters and Getters
	
	public void setValue(byte value){
		this.value = value;
	}
	
	public void setColor(Color c){
		this.c = c;
	}

	public byte getValue() {
		return value;
	}
}
