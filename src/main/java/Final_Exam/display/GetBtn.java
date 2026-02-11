package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import Final_Exam.utils.ErrHandle;
import javax.swing.*;
import java.awt.*;

/**
 * Factory class for creating button panels.
 */
class GetBtn {

	private static final int VERTICAL_GAP = 30;
	private static final int BOTTOM_PADDING = 250;
	private static final int BUTTON_WIDTH = 300;
	private static final int BUTTON_HEIGHT = 100;

	// Private constructor to prevent instantiation
	private GetBtn() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	/**
	 * Creates and returns the main menu panel with Play and Setting buttons.
	 * 
	 * @return A JPanel configured as the menu.
	 */
	public static JPanel createMenuPanel() {
		JPanel panel = createBasePanel();

		panel.add(Box.createVerticalGlue());

		JButton playBtn = createButton(ImagePath.PLAY_BTN_NORMAL, ImagePath.PLAY_BTN_HOVER);
		if (playBtn != null)
			panel.add(playBtn);

		panel.add(Box.createVerticalStrut(VERTICAL_GAP));

		JButton settingBtn = createButton(ImagePath.SETTING_BTN_NORMAL, ImagePath.SETTING_BTN_HOVER);
		if (settingBtn != null)
			panel.add(settingBtn);

		panel.add(Box.createVerticalGlue());

		return panel;
	}

	/**
	 * Creates and returns the settings panel.
	 * 
	 * @return a JPanel configured for settings.
	 */
	public static JPanel createSettingPanel() {
		JPanel panel = createBasePanel();
		// Currently empty based on original code, but prepared for expansion
		return panel;
	}

	private static JPanel createBasePanel() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, BOTTOM_PADDING, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false); // Assuming we want transparency for background
		return panel;
	}

	private static JButton createButton(ImagePath normalImgPath, ImagePath hoverImgPath) {
		try {
			ImageIcon normalIcon = new ImageIcon(ImgRes.getPath(normalImgPath));
			ImageIcon hoverIcon = new ImageIcon(ImgRes.getPath(hoverImgPath));

			JButton btn = new JButton(normalIcon);
			configureButtonAppearance(btn);

			BtnHovEff.applyHoverEffect(btn, normalIcon, hoverIcon);

			return btn;
		} catch (Exception e) {
			ErrHandle.handleImageLoadingError(e);
			return null;
		}
	}

	private static void configureButtonAppearance(JButton btn) {
		btn.setFocusable(true);
		btn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Transparent properties
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setOpaque(false);
		btn.setFocusPainted(false);
	}
}
