package com.Final_Exam.display;

import javax.swing.*;
import java.awt.*;

public class Display {
	JFrame mainFrame;
	public Display() {
		this.initialize();
	}
	public void initialize() {
		mainFrame = new JFrame("Final Exam");
		mainFrame.setSize(1024, 768);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}
