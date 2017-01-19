package de.sudoku;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	
	private byte value, size;
	private Color c = new Color(255);
	
	public Cell(byte size){
		this.size = size;
		value = -1;
	}
	
	public void paint(Graphics g, int x, int y){
		g.setColor(c);
		g.fillRect(x,  y, size, size);
		g.setColor(Color.black);
		g.drawRect(x,  y, size, size);
		if(value!=-1)	g.drawString(Byte.toString(value), size/2-5, size/2-5);
		
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
