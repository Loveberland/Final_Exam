package Final_Exam.display;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Final_Exam.enums.ImagePath;

class StoryGameFrame {
	private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
	private static PauseSystem pauseMenu;

	public static JPanel createGamePanel() {
		JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));

		gameContentPanel = new JPanel(new BorderLayout()) {
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
			"On the first day of the semester, a young male student stepped into one of the country\'s top universities, a place known to \"create geniuses\" and \"swallow the weak.\"\n" +
			"At the same time, he chose a major that didn't exist in the regular curriculum, a field listed only as \"Special Program,\" with no further explanation.",
			"The moment the university gates closed, a murky toxic fog spread outward, swallowing the outside world until not even a single communication signal remained. Those who tried\n" +
			"Those who tried to escape fell and died. Those who tried to resist disappeared. And those who surrendered... slowly lost their humanity. The student uncovered a cruel truth",
			"This was not an educational institution, but an experimental ground. Knowledge was not a tool for growth, but a weapon. Grades were not a measure of ability, but the line between life and death",
			"Above this university, the \"Overseers\" ruled. Each of them wielded forbidden disciplines, far too powerful for any student to oppose. They" +
			"They controlled the curriculum, distorted the truth, and selected only those who were \"fit to survive.\"\n",
			"Amid the despair, a forbidden legend was whispered among the shadowed students: \"If anyone possesses a heart that does not shatter, and an intellect that refuses to bow\n" +
			"and can bring down all the Overseers, the fog will fade, and the gates to the outside world will open once more\"\n"
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
								JPanel heroTalkPanel = HeroTalk.createGamePanel();
								parentFrame.setContentPane(heroTalkPanel);
								parentFrame.revalidate(); parentFrame.repaint();
								heroTalkPanel.requestFocusInWindow();
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
