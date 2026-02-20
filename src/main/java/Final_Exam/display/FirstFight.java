package Final_Exam.display;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;

import Final_Exam.enums.ImagePath;
import Final_Exam.enums.FirstQuestion;
import Final_Exam.models.Boss;
import Final_Exam.models.Nisit;

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

		gameContentPanel = new JPanel() {
			private Image backgroundImage = new ImageIcon(ImgRes.getPath(ImagePath.BG)).getImage();

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
		gameContentPanel.add(hero, BorderLayout.WEST);

                boss = ImgPanel.createImgLabel(ImagePath.SUN, 100, 300);
                boss.setBounds(800, 200, 100, 400);
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

		Nisit hero = new Nisit();
		Boss san = new Boss("Santana");

		// 1
		JLabel fisrtQuestionLabel = new JLabel(FirstQuestion.DFS_Q.getQuestionHtml());
		GetQuestAnsDialog firstQuestion = new GetQuestAnsDialog(parentFrame, "depth_first_search", fisrtQuestionLabel, hero, san);
		firstQuestion.setVisible(true);

		// 2
		JLabel secondQuestionLabel = new JLabel(FirstQuestion.BINARY_SEARCH_Q.getQuestionHtml());
		GetQuestAnsDialog secondQuestion = new GetQuestAnsDialog(parentFrame, "binary_search", secondQuestionLabel, hero, san);
		secondQuestion.setVisible(true);

		// 3
		JLabel thridQuestionLabel = new JLabel(FirstQuestion.INSERTION_SORT_Q.getQuestionHtml());
		GetQuestAnsDialog thirdQuestion = new GetQuestAnsDialog(parentFrame, "insertion_sort", thridQuestionLabel, hero, san);
		thirdQuestion.setVisible(true);
	}
}
