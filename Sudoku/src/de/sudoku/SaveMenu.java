package de.sudoku;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class SaveMenu {

	private BufferedWriter bw;
	private JFileChooser filechooser;
	private File file;
	
	public SaveMenu(String filename) {
		String userhome = System.getProperty("user.home");
		filechooser = new JFileChooser(userhome+File.separator+"Desktop");
		filechooser.setDialogTitle("Save a sudoku file:");
	}
	
	public void createCustomFile(Cell[][] cells){
		try {
			bw = null;
			int state = filechooser.showSaveDialog(null);
			file = filechooser.getSelectedFile();
			if(state == JFileChooser.APPROVE_OPTION){
				bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()+".txt"));
//				bw.write(String.valueOf(Cell.getColor().getRed()));
//				bw.newLine();
			
				
			JOptionPane.showMessageDialog(null, "Data has been saved!");
			}
			
			if(bw!=null){
				bw.close();
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to save!");
			e.printStackTrace();
		}
	}
}

