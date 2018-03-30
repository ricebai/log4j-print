package com;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LogFrame {

	public LogFrame() {
		
		JFrame fr = new JFrame("Log Frame");
		
		fr.setLayout(new BorderLayout());
		
		fr.add(new Center(), BorderLayout.CENTER);
		
		fr.setSize(400, 500);
		fr.setDefaultCloseOperation(3);
		fr.setVisible(true);
	}
	
	public static void main(String[] args) {
		new LogFrame();
	}
}
