package Final_Exam.display;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.util.List;
import java.util.Collections;

import java.awt.*;
import java.awt.event.ActionEvent;

import Final_Exam.enums.ImagePath;
import Final_Exam.models.Boss;
import Final_Exam.models.Nisit;

/**
 * Manages the primary battle logic and UI for the game's first boss fight.
 * This class orchestrates character instantiation (Hero vs. Boss), pulls
 * questions
 * from the QuestionBank, and displays the battle sequences in a loop until
 * someone dies.
 */
public class FirstFight {
	private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
	private static PauseSystem pauseMenu;
	private static JLabel hero;
	private static JLabel boss;

	/**
	 * Creates and initializes the main game panel for the first fight sequence.
	 * Configures the background, characters, layered pane, and attaches an ancestor
	 * listener to start the battle sequence when the panel is displayed.
	 *
	 * @return A configured JPanel representing the battle screen.
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

	/**
	 * Sets up a key binding listening for the 'ESCAPE' key to toggle
	 * the visibility of the pause menu.
	 *
	 * @param panel The main wrapper panel to bind the key event to.
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
	 * Configures the introductory sequence that triggers exactly when the
	 * panel is added to the screen hierarchy.
	 *
	 * @param panel The main wrapper panel to attach the listener to.
	 */
	private static void setupStoryLogic(JPanel panel) {
		String[] story = {
				"You\'ve made it this far… how interesting. Hundreds of students fell before they ever saw my face. No matter how strong we think we are… in the end, everyone breaks. And I will be your final lesson.",
				"How bold of you to walk up to me without kneeling. Do you think you\'re some kind of guardian? There are no guardians here—only survivors… and the erased.",
				"Remember this well: after today, your name will be nothing but a zero. And I will be your final lesson."
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
			public void ancestorRemoved(AncestorEvent event) {
			}

			public void ancestorMoved(AncestorEvent event) {
			}

		});
	}

	/**
	 * Initiates the main battle loop. Randomizes questions from the question bank
	 * and presents them to the player sequentially until someone's HP drops to 0.
	 *
	 * @param parentFrame The main application window frame.
	 */
	private static void fight(JFrame parentFrame) {

		layeredPane.add(new WhenFight().createGamePanel(), Integer.valueOf(1));
		parentFrame.repaint();

		Nisit hero = new Nisit("Kittipong");
		Boss san = new Boss("Santana");

		List<Question> questions = QuestionBank.getAllQuestions();

		Collections.shuffle(questions);

		for (Question q : questions) {

			JLabel questionLabel = new JLabel(q.getQuestionHtml());

			GetQuestAnsDialog dialog = new GetQuestAnsDialog(
					parentFrame,
					q.getCorrectAnswer(),
					questionLabel,
					hero,
					san);

			dialog.setVisible(true);

			if (hero.getHp() <= 0 || san.getHp() <= 0)
				break;
		}
		checkDie(hero, san, parentFrame);
	}

	/**
	 * Evaluates the results of the fight and transitions to the ending screen.
	 *
	 * @param hero        The player character object.
	 * @param san         The boss character object.
	 * @param parentFrame The main application window frame.
	 */
	private static void checkDie(Nisit hero, Boss san, JFrame parentFrame) {
		if (hero.getHp() <= 0)
			new Ending(san, parentFrame);
		else if (san.getHp() <= 0)
			new Ending(hero, parentFrame);
	}
}
