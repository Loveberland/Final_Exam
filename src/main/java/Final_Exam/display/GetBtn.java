package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import Final_Exam.utils.ErrHandle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Factory class for creating button panels.
 */
class GetBtn {

	private static final int VERTICAL_GAP = 30;
	private static final int BOTTOM_PADDING = 250;
	private static final int BUTTON_WIDTH = 300;
	private static final int BUTTON_HEIGHT = 100;
	private static final int SLIDER_WIDTH = 300;
	private static final int SLIDER_HEIGHT = 40;

	/**
	 * Private constructor to prevent instantiation
	 */	
	private GetBtn() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	/**
	 * Creates and returns the main menu panel with Play and Setting buttons.
	 *
	 * @param onSettingClicked Action to execute when the Settings button is clicked.
	 * @param onPlayClicked Action to execute when the Play button is clicked.
	 * @return A JPanel configured as the menu.
	 */
	public static JPanel createMenuPanel(ActionListener onSettingClicked, ActionListener onPlayClicked) {
		JPanel panel = createBasePanel();

		addLogoToPanel(panel);

		panel.add(Box.createVerticalGlue());

		JButton playBtn = createButton(ImagePath.PLAY_BTN_NORMAL, ImagePath.PLAY_BTN_HOVER);
		if (playBtn != null) {
			playBtn.addActionListener(onPlayClicked);
			panel.add(playBtn);
		}

		panel.add(Box.createVerticalStrut(VERTICAL_GAP));

		JButton settingBtn = createButton(ImagePath.SETTING_BTN_NORMAL, ImagePath.SETTING_BTN_HOVER);
		if (settingBtn != null) {
			settingBtn.addActionListener(onSettingClicked);
			panel.add(settingBtn);
		}

		panel.add(Box.createVerticalGlue());

		return panel;
	}

	/**
	 * Creates and returns the settings panel containing the Sound icon, 
	 * Volume slider, and Back button.
	 *
	 * @param onBackClicked Action to execute when the Back button is clicked.
	 * @return A configured JPanel representing the settings menu.
	 */	
	public static JPanel createSettingPanel(ActionListener onBackClicked) {
		JPanel panel = createBasePanel();

		panel.add(Box.createVerticalStrut(-14));

		addLogoToPanel(panel);

		try {
			String soundPath = ImgRes.getPath(ImagePath.SOUND_HOVER);
			ImageIcon soundIcon = new ImageIcon(soundPath);
			JLabel soundLabel = new JLabel(soundIcon);
			soundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(soundLabel);
		} catch (Exception e) {
			ErrHandle.handleImageLoadingError(e);
		}

		panel.add(Box.createVerticalStrut(10));

		JSlider volume = createVolumeSlider();
		if (volume != null) {
			panel.add(volume);
		}

		panel.add(Box.createVerticalStrut(VERTICAL_GAP));

		JButton backBtn = createButton(ImagePath.BACK_BTN_NORMAL, ImagePath.BACK_BTN_HOVER);
		if (backBtn != null) {
			backBtn.addActionListener(onBackClicked);
			panel.add(backBtn);
		}

		panel.add(Box.createVerticalGlue());

		return panel;
	}

	/**
	 * Creates the game logo and adds it to the provided panel.
	 *
	 * @param panel The JPanel to which the logo should be added.
	 */
	private static void addLogoToPanel(JPanel panel) {
		JLabel logo = ImgPanel.createImgLabel(ImagePath.LOGO, 800, 300);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(logo);
		panel.add(Box.createVerticalStrut(20));
	}

	/**
	 * Creates a base JPanel configured with a transparent background 
	 * and a vertical box layout.
	 *
	 * @return The base JPanel.
	 */
	private static JPanel createBasePanel() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, BOTTOM_PADDING, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false); // Assuming we want transparency for background
		return panel;
	}

	/**
	 * Creates a customized JButton with specific normal and hover icons.
	 *
	 * @param normalImgPath The ImagePath for the button's normal state.
	 * @param hoverImgPath  The ImagePath for the button's hover state.
	 * @return The constructed JButton, or null if the images fail to load.
	 */
	public static JButton createButton(ImagePath normalImgPath, ImagePath hoverImgPath) {
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

	/**
	 * Configures the appearance of a JButton to make it transparent and properly aligned.
	 *
	 * @param btn The JButton to configure.
	 */
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

	/**
	 * Creates and configures a horizontal JSlider to act as a volume control.
	 *
	 * @return The configured JSlider.
	 */
	private static JSlider createVolumeSlider() {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setPreferredSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
		slider.setMaximumSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
		slider.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOpaque(false);
		return slider;
	}
}
