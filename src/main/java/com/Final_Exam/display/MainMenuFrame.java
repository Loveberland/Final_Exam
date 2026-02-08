package com.Final_Exam.display;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame {
	JFrame frame;
	ImageIcon gameName;
	JPanel btnPanel;

	public MainMenuFrame() {
		initialize();
		addGameName();
		addBtn();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Final Exam");
		frame.setSize(1280, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
	}

	private void addGameName() {
		try {
			ImageIcon pic = new ImageIcon("src/resources/image/Logo.png");
			JLabel gameNameLabel = new JLabel(pic);
			gameNameLabel.setHorizontalAlignment(JLabel.CENTER);
			gameNameLabel.setPreferredSize(new Dimension(800, 300));
			frame.add(gameNameLabel, BorderLayout.NORTH);
		} catch (Exception e) {
			notFoundPic();
		}
	}

	private void addBtn() {
		btnPanel = new JPanel();
		btnPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50 ,0));
		btnPanel.setLayout(new GridLayout(3, 3, 50, 50));
		addPlayBtn();
		addSettingBtn();
		frame.add(btnPanel, BorderLayout.CENTER);
	}

	private void addPlayBtn() {
		try {
			ImageIcon pic = new ImageIcon("src/resources/image/btnPlay.png");
			JButton playBtn = new JButton(pic);
			playBtn.setFocusable(true);
			playBtn.setPreferredSize(new Dimension(300, 100));
			transparentBtn(playBtn);
			btnPanel.add(playBtn);
		} catch (Exception e) {
			notFoundPic();
		}
	}

	private void addSettingBtn() {
		try {
			ImageIcon pic = new ImageIcon("src/resources/image/btnSetting.png");
			JButton settingBtn = new JButton(pic);
			settingBtn.setFocusable(true);
			settingBtn.setPreferredSize(new Dimension(300, 100));
			transparentBtn(settingBtn);
			btnPanel.add(settingBtn);
		} catch (Exception e) {
			notFoundPic();
		}
	}

	private void transparentBtn(JButton btn) {
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setFocusPainted(false);
	}

	private void notFoundPic() {
		System.err.println("Picture not found");
		System.exit(1);
	}
}
