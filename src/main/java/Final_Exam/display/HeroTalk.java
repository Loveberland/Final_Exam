package Final_Exam.display;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Final_Exam.enums.ImagePath;


/**
 * Manages the pre-battle dialogue sequence for the hero character.
 * Displays a series of dramatic lines before transitioning into the actual fight.
 */
class HeroTalk {
	private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
	private static PauseSystem pauseMenu;
	private static JLabel hero;

	/**
     	 * Creates the panel where the hero's monologue occurs. Sets up the 
     	 * background, hero image, key bindings, and story logic.
     	 *
     	 * @return The configured JPanel for the hero's dialogue sequence.
     	 */
	public static JPanel createGamePanel() {
		JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));

		gameContentPanel = new JPanel() {
			private Image backgroundImage = new ImageIcon(ImgRes.getPath(ImagePath.FIGHT_BG)).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		gameContentPanel.setLayout(null);
		gameContentPanel.setBounds(0, 0, 1280, 960);

		pauseMenu = new PauseSystem(1280, 960, e -> {
			System.out.println("Game Resume");
		});

		hero = ImgPanel.createImgLabel(ImagePath.HERO, 100, 300);
		hero.setBounds(150, 200, 500, 400);
		gameContentPanel.add(hero);

		layeredPane.add(gameContentPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(pauseMenu, JLayeredPane.PALETTE_LAYER);

		setupPauseKeyBinding(mainWrapper);
		setupStoryLogic(mainWrapper);

		mainWrapper.add(layeredPane, BorderLayout.CENTER);
		return mainWrapper;
	}

	/**
     	 * Binds the Escape key to toggle the pause menu.
     	 *
     	 * @param panel The panel listening for the keypress.
     	 */
	private static void setupPauseKeyBinding(JPanel panel) {
		InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "togglePause");
		ActionMap actionMap = panel.getActionMap();
		actionMap.put("togglePause", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseMenu.toggle();
				System.out.println("Pause Toggle: " + pauseMenu.isVisible());
			}
		});
	}

	/**
     	 * Sets up the sequential story dialogue. When the text completes, 
     	 * it triggers a transition to the `FirstFight` panel.
     	 *
     	 * @param panel The main panel to attach the load listener to.
     	 */
	private static void setupStoryLogic(JPanel panel) {
		String[] story = {
                        "If this place is an experiment, then I\'ll be your mistake",
                        "You use knowledge as a weapon, but I\'ll use it as a tool in this hell.",
			"Grades might decide whether others live or die, but they will never decide my life.",
			"If surviving means losing my humanity, then I choose to fight."

		};

		panel.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorAdded(AncestorEvent event) {
				Window window = SwingUtilities.getWindowAncestor(panel);
				if (window instanceof JFrame) {
					JFrame parentFrame = (JFrame) window;

					SwingUtilities.invokeLater(() -> {
						if (!pauseMenu.isVisible()) {
							Dialogues intro = new Dialogues(parentFrame, story, () -> {
								JPanel fightPanel = FirstFight.createGamePanel();
								parentFrame.setContentPane(fightPanel);
								parentFrame.revalidate(); parentFrame.repaint();
								fightPanel.requestFocusInWindow();
							});
							intro.setVisible(true);
						}
					});
				}

				panel.removeAncestorListener(this);
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {}

			public void ancestorMoved(AncestorEvent event) {}

		});
	}
}
