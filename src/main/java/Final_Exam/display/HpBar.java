package Final_Exam.display;

import javax.swing.*;
import java.awt.*;

class HpBar extends JPanel {
	private int curHp;
	private int maxHp;
	private Color barColor;

	private static final Font TEXT_FONT = new Font("Arial", Font.BOLD, 30);

	public HpBar(int curHp, int maxHp, Color barColor) {
		this.curHp = curHp;
		this.maxHp = maxHp;
		this.barColor = barColor;

		this.setOpaque(false);
	}

	public void updateHp(int curHp) {
		this.curHp = curHp;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(barColor);

		g2d.fillRect(0, 0, getWidth(), getHeight());

		String text = curHp + "/" + maxHp;
		g2d.setColor(Color.BLACK);
		g2d.setFont(TEXT_FONT);

		FontMetrics metrics = g2d.getFontMetrics(TEXT_FONT);
		int x = (getWidth() - metrics.stringWidth(text)) / 2;
		int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

		g2d.drawString(text, x, y);
	}
}
