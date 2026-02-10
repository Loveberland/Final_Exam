package Final_Exam.display;

import javax.swing.*;
import java.awt.*;
import Final_Exam.display.BtnHoverEff;

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
		btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 250 ,0));
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));

		btnPanel.add(Box.createVerticalGlue());
		addPlayBtn();
		btnPanel.add(Box.createVerticalStrut(30));
		addSettingBtn();
		btnPanel.add(Box.createVerticalGlue());
		frame.add(btnPanel, BorderLayout.CENTER);
	}

	private void addPlayBtn() {
		try {
			ImageIcon nonHover = new ImageIcon("src/resources/image/nonHoverBtnPlay.png");
			ImageIcon hover = new ImageIcon("src/resources/image/hoverBtnPlay.png");

			JButton playBtn = new JButton(nonHover);
			playBtn.setFocusable(true);
			playBtn.setPreferredSize(new Dimension(300, 100));
			playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			transparentBtn(playBtn);

			BtnHoverEff.applyHoverEff(playBtn, nonHover, hover);

			btnPanel.add(playBtn);
		} catch (Exception e) {
			notFoundPic();
		}
	}

	private void addSettingBtn() {
		try {
			ImageIcon nonHover = new ImageIcon("src/resources/image/nonHoverBtnSetting.png");
			ImageIcon hover = new ImageIcon("src/resources/image/hoverBtnSetting.png");

			JButton settingBtn = new JButton(nonHover);
			settingBtn.setFocusable(true);
			settingBtn.setPreferredSize(new Dimension(300, 100));
			settingBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			transparentBtn(settingBtn);

			BtnHoverEff.applyHoverEff(settingBtn, nonHover, hover);

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
