package Final_Exam.display;

import javax.swing.*;

import Final_Exam.enums.ImagePath;

import java.awt.*;
import java.awt.event.ActionListener;

class PauseSystem extends JPanel {
	private final ActionListener resumeAction;

	public PauseSystem(int wid, int hei, ActionListener resumeAction) {
		this.resumeAction = resumeAction;
		this.setBounds(0, 0, wid, hei);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());

		JLabel pauseLabel = ImgPanel.createImgLabel(ImagePath.PAUSE, 800, 300);
		this.add(pauseLabel, BorderLayout.CENTER);

		this.setVisible(false);
	}

	public void toggle() {
		this.setVisible(!this.isVisible());
	}

	private void resumeGame() {
		this.setVisible(false);
		if (resumeAction != null) {
			resumeAction.actionPerformed(null);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 0, 0, 255));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
