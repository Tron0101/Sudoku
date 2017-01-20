package de.sudoku;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	
	private byte value, size;
	private int x, y;
	private Color c = new Color(255);
	
	public Cell(byte size, int x, int y){
		this.size = size;
		this.x = x;
		this.y = y;
		value = 4;
	}
	
	public void paint(Graphics g, int x, int y){
		g.setColor(c);
		g.fillRect(x,  y, size, size);
		g.setColor(Color.black);
		g.drawRect(x,  y, size, size);
		if(value!=-1)	g.drawString(Byte.toString(value), x+Frame.CELLSIZE/2, y+Frame.CELLSIZE/2);
		
	}

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
