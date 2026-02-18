package Final_Exam.display;

import javax.swing.*;
import java.awt.*;

public class WhenFight {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 960;

	private static final int BAR_WIDTH = 250;
	private static final int BAR_HEIGHT = 40;
	private static final int MARGIN = 20;

	private static HpBar hero;
	private static HpBar boss;

	public static JPanel createGamePanel() {
		JPanel hpBarPanel = new JPanel();
		hpBarPanel.setLayout(null);
		hpBarPanel.setBounds(0, 0, 1280, 960);
		hpBarPanel.setOpaque(false);

		hero = new HpBar(100, 100, Color.RED);
		hero.setBounds(MARGIN, MARGIN, BAR_WIDTH, BAR_HEIGHT);

		boss = new HpBar(250, 250, Color.RED);
		boss.setBounds(WIDTH - BAR_WIDTH - MARGIN * 2, MARGIN, BAR_WIDTH, BAR_HEIGHT);

		hpBarPanel.add(hero);
		hpBarPanel.add(boss);

		return hpBarPanel;
	}
}
