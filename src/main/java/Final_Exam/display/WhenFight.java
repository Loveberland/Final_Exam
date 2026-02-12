package Final_Exam.display;

import Final_Exam.display.HpBar;
import Final_Exam.enums.ImagePath;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WhenFight {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 960;

	private static final int BAR_WIDTH = 250;
	private static final int BAR_HEIGHT = 40;
	private static final int MARGIN = 20;

	public static JPanel createGamePanel() {
		JPanel rootPanel = new JPanel(new BorderLayout());

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setBounds(0, 0, WIDTH, HEIGHT);

		HpBar nisitHpBar = new HpBar(100, 100, Color.RED);
		nisitHpBar.setBounds(MARGIN, MARGIN, BAR_WIDTH, BAR_HEIGHT);

		int x_axis = WIDTH - BAR_WIDTH - MARGIN;
		HpBar bossHpBar = new HpBar(250, 250, Color.RED);
		bossHpBar.setBounds(MARGIN, MARGIN, BAR_WIDTH, BAR_HEIGHT);

		layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(nisitHpBar, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(bossHpBar, JLayeredPane.PALETTE_LAYER);

		layeredPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				backgroundPanel.setSize(layeredPane.getSize());
				bossHpBar.setLocation(layeredPane.getWidth() - BAR_WIDTH - MARGIN, MARGIN);
			}
		});

		rootPanel.add(layeredPane, BorderLayout.CENTER);
		return rootPanel;
	}
}
