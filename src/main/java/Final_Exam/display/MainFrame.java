package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import Final_Exam.interfaces.DisplayComponent;
import java.awt.event.*;
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
	private CardLayout cardLayout;
	private JPanel mainContainer;

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
		initCardLayout();
	}

	private void initCardLayout() {
		cardLayout = new CardLayout();
		mainContainer = new JPanel(cardLayout);
		mainContainer.setOpaque(false);

		ActionListener switchToSetting = e -> {
			cardLayout.show(mainContainer, "Setting");
		};

		ActionListener switchToMenu = e -> {
			cardLayout.show(mainContainer, "Menu");
		};

		ActionListener switchToGame = e -> {
			cardLayout.show(mainContainer, "Game");
		};

		JPanel menuPanel = GetBtn.createMenuPanel(switchToSetting, switchToGame);
		JPanel settingPanel = GetBtn.createSettingPanel(switchToMenu);
		JPanel gamePanel = StoryGameFrame.createGamePanel();

		mainContainer.add(menuPanel, "Menu");
		mainContainer.add(settingPanel, "Setting");
		mainContainer.add(gamePanel, "Game");

		frame.add(mainContainer, BorderLayout.CENTER);

		cardLayout.show(mainContainer, "Menu");
	}
}
