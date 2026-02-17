package Final_Exam.display;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

class StoryGameFrame {
	private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
	private static PauseSystem pauseMenu;
	private static JPanel fightPanel;
	private static DialogBox dialogBox;

	public static JPanel createGamePanel() {
		JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));

		gameContentPanel = new JPanel();
		gameContentPanel.setLayout(null);
		gameContentPanel.setBackground(Color.WHITE);
		gameContentPanel.setBounds(0, 0, 1280, 960);

		fightPanel = WhenFight.createGamePanel();
		fightPanel.setBounds(0, 0, 1280, 960);
		fightPanel.setVisible(false);

		pauseMenu = new PauseSystem(1280, 960, e -> {
			System.out.println("Game Resume");
		});

		dialogBox = new DialogBox();
		dialogBox.setBounds(340, 700, 600, 200); // กลางล่าง
		dialogBox.setVisible(false);

		layeredPane.add(dialogBox, JLayeredPane.MODAL_LAYER);

		layeredPane.add(gameContentPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(fightPanel, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(pauseMenu, JLayeredPane.MODAL_LAYER);

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

		panel.addAncestorListener(new AncestorListener() {

			@Override
			public void ancestorAdded(AncestorEvent event) {

				SwingUtilities.invokeLater(() -> {

					dialogBox.setVisible(true);
					dialogBox.requestFocusInWindow();

				});

				panel.removeAncestorListener(this);
			}

			public void ancestorRemoved(AncestorEvent event) {}
			public void ancestorMoved(AncestorEvent event) {}

		});
	}
}