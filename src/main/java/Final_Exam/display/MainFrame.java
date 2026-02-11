package Final_Exam.display;

import Final_Exam.interfaces.DisplayComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Main application window frame.
 */
public class MainFrame {

	// Constants for Window configuration
	private static final String WINDOW_TITLE = "Final Exam";
	private static final int WINDOW_WIDTH = 1280;
	private static final int WINDOW_HEIGHT = 960;

	private JFrame frame;

	public MainFrame() {
		initializeFrame();
		addComponents();
	}

	public void show() {
		frame.setVisible(true);
	}

	private void initializeFrame() {
		frame = new JFrame(WINDOW_TITLE);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	private void addComponents() {
		addLogo();
		addMenu();
	}

	private void addLogo() {
		// Logo is a static factory now
		JLabel logoLabel = Logo.createLogoLabel();
		frame.add(logoLabel, BorderLayout.NORTH);
	}

	private void addMenu() {
		// GetBtn is a static factory now
		JPanel menuPanel = GetBtn.createMenuPanel();
		frame.add(menuPanel, BorderLayout.CENTER);
	}

	// Kept for potential future use or if called externally (though private in
	// original)
	private void addSettings() {
		JPanel settingPanel = GetBtn.createSettingPanel();
		frame.add(settingPanel, BorderLayout.CENTER);
	}
}
