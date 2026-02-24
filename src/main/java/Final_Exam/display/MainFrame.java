package Final_Exam.display;

import Final_Exam.enums.ImagePath;
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

	/**
	 * Constructs a new MainFrame.
  	 * Initializes the window frame properties and builds the component.
	 */
	public MainFrame() {
		initializeFrame();
		addComponents();
	}

	/**
	 * Make main frame visible to the user.
	 */
	public void show() {
		frame.setVisible(true);
	}

	/**
         * Configures the core properties of the JFrame, such as its size
 	 */
	private void initializeFrame() {
		frame = new JFrame(WINDOW_TITLE);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	/**
	 * Add component to main frame
	 */
	private void addComponents() {
		initCardLayout();
	}

	/**
	 * Initializes the CardLayout and the main container. 
	 * Sets up the navigation logic (ActionListeners) to switch between the 
	 * Menu, Setting, and Game panels. Also applies a custom background image 
	 * that renders behind the transparent main container.
	 */
	private void initCardLayout() {
		cardLayout = new CardLayout();
		mainContainer = new JPanel(cardLayout);
		mainContainer.setOpaque(false);

		// ActionListener to switch to the setting panel
		ActionListener switchToSetting = e -> {
			cardLayout.show(mainContainer, "Setting");
		};

		// ActionListener to switch to the main menu panel
		ActionListener switchToMenu = e -> {
			cardLayout.show(mainContainer, "Menu");
		};

		// ActionListener to switch to the game panel
		ActionListener switchToGame = e -> {
			cardLayout.show(mainContainer, "Game");
		};

		JPanel menuPanel = GetBtn.createMenuPanel(switchToSetting, switchToGame);
		JPanel settingPanel = GetBtn.createSettingPanel(switchToMenu);
		JPanel gamePanel = StoryGameFrame.createGamePanel();

		mainContainer.add(menuPanel, "Menu");
		mainContainer.add(settingPanel, "Setting");
		mainContainer.add(gamePanel, "Game");

		// Add background path
		JPanel bgPanel = new JPanel(new BorderLayout()) {
			private Image backgroundImage = new ImageIcon(ImgRes.getPath(ImagePath.BG)).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		bgPanel.add(mainContainer, BorderLayout.CENTER);

		frame.add(bgPanel, BorderLayout.CENTER);

		// Set the initial screen to main menu
		cardLayout.show(mainContainer, "Menu");
	}
}
