package Final_Exam.display;

import Final_Exam.utils.ErrHandle;
import Final_Exam.display.BtnHovEff;
import Final_Exam.display.ImgRes;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class GetBtn {
	private JPanel panel;

	private void getMenuBtn() {
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 250, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
		addPlayBtn();
		panel.add(Box.createVerticalStrut(30));
		addSettingBtn();
		panel.add(Box.createVerticalGlue());
	}

	private void addPlayBtn() {
		try {
			ImageIcon playNor = new ImageIcon(ImgRes.N_HOV_PLAY_BTN);
			ImageIcon playHov = new ImageIcon(ImgRes.HOV_PLAY_BTN);
			JButton playBtn = new JButton(playNor);
			playBtn.setFocusable(true);
			playBtn.setPreferredSize(new Dimension(300, 100));
			playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			transparent(playBtn);
			BtnHovEff.applyHovEff(playBtn, playNor, playHov);
			panel.add(playBtn);
		} catch (Exception e) {
			ErrHandle.imgErr(e);
		}
	}

	private void addSettingBtn() {
		try {
			ImageIcon settingNor = new ImageIcon(ImgRes.N_HOV_SETTING_BTN);
			ImageIcon settingHov = new ImageIcon(ImgRes.HOV_SETTING_BTN);
			JButton settingBtn = new JButton(settingNor);
			settingBtn.setFocusable(true);
			settingBtn.setPreferredSize(new Dimension(300, 100));
			settingBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			transparent(settingBtn);
			BtnHovEff.applyHovEff(settingBtn, settingNor, settingHov);
			panel.add(settingBtn);
		} catch (Exception e) {
			ErrHandle.imgErr(e);
		}
	}

	private void getSettingBtn() {

	}

	private void transparent(JButton btn) {
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setFocusPainted(false);
	}

	public static JPanel getMenuPanel() {
		GetBtn instance = new GetBtn();
		instance.getMenuBtn();
		return instance.panel;
	}

	public static JPanel getSettingPanel() {
		GetBtn instance = new GetBtn();
		instance.getSettingBtn();
		return instance.panel;
	}
}
