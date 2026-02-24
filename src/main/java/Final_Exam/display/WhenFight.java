package Final_Exam.display;

import javax.swing.*;
import java.awt.*;

/**
 * Manages the heads-up display (HUD) during a battle sequence, specifically
 * rendering and updating the HP bars for both the hero and the boss.
 */
public class WhenFight {
	private static final int WIDTH = 1280;

	private static final int BAR_WIDTH = 250;
	private static final int BAR_HEIGHT = 40;
	private static final int MARGIN = 20;

	private static HpBar hero;
	private static HpBar boss;

	/**
	 * Creates and configures the panel containing the health bars.
	 *
	 * @return A transparent JPanel containing the positioned HP bars.
	 */
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

	/**
	 * Updates the hero's displayed HP, ensuring it doesn't drop below 0.
	 *
	 * @param hp The new current HP value for the hero.
	 */
	public static void updateHeroHp(int hp) {
		if (hp < 0)
			hp = 0;
		if (hero != null) {
			hero.updateHp(hp);
		}
	}

	/**
	 * Updates the boss's displayed HP, ensuring it doesn't drop below 0.
	 *
	 * @param hp The new current HP value for the boss.
	 */
	public static void updateBossHp(int hp) {
		if (hp < 0)
			hp = 0;
		if (boss != null) {
			boss.updateHp(hp);
		}
	}
}
