package Final_Exam.display;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;

import Final_Exam.enums.ImagePath;

public class FirstFight {
	private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
	private static PauseSystem pauseMenu;
	private static JLabel hero;
        private static JLabel boss;

	public static JPanel createGamePanel() {
		JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));

		gameContentPanel = new JPanel();
		gameContentPanel.setLayout(null);
		gameContentPanel.setBackground(Color.WHITE);
		gameContentPanel.setBounds(0, 0, 1280, 960);

		pauseMenu = new PauseSystem(1280, 960, e -> {
			System.out.println("Game Resume");
		});

		hero = ImgPanel.createImgLabel(ImagePath.HERO, 100, 300);
		hero.setBounds(150, 200, 100, 400);
		gameContentPanel.add(hero, BorderLayout.WEST);

                boss = ImgPanel.createImgLabel(ImagePath.SUN, 100, 300);
                boss.setBounds(1000, 200, 100, 400);
                gameContentPanel.add(boss, BorderLayout.EAST);

		layeredPane.add(gameContentPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(pauseMenu, JLayeredPane.PALETTE_LAYER);

		setupPauseKeyBinding(mainWrapper);
		setupStoryLogic(mainWrapper);

		mainWrapper.add(layeredPane, BorderLayout.CENTER);
		return mainWrapper;
	}

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

	private static void setupStoryLogic(JPanel panel) {
		String[] story = {
                        "Well Well Well...",
                        "Let see what you have...",
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
								fight(parentFrame);
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

	private static void fight(JFrame parentFrame) {
		layeredPane.add(new WhenFight().createGamePanel(), Integer.valueOf(1));
		parentFrame.repaint();

		GetQuestAnsDialog firstQuestion = new GetQuestAnsDialog(parentFrame, ImagePath.LOGO, "Boot Boot");
		firstQuestion.setVisible(true);
	}
}
