package Final_Exam.display;

import javax.swing.*;

import Final_Exam.enums.ImagePath;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A custom JPanel that acts as a semi-transparent overlay for the pause menu.
 * It darkens the screen and displays a "PAUSE" graphic.
 */
class PauseSystem extends JPanel {
	private final ActionListener resumeAction;

	/**
	 * Constructs the PauseSystem overlay.
	 *
	 * @param wid          The width of the overlay (usually matching the window).
	 * @param hei          The height of the overlay.
	 * @param resumeAction The action to execute when unpausing.
	 */
	public PauseSystem(int wid, int hei, ActionListener resumeAction) {
		this.resumeAction = resumeAction;
		this.setBounds(0, 0, wid, hei);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());

		JLabel pauseLabel = ImgPanel.createImgLabel(ImagePath.PAUSE, 800, 300);
		this.add(pauseLabel, BorderLayout.CENTER);

		this.setVisible(false);
	}

	/**
	 * Toggles the visibility state of the pause overlay.
	 */
	public void toggle() {
		this.setVisible(!this.isVisible());
	}

	/**
	 * Hides the pause overlay and triggers the resume action callback.
	 */
	private void resumeGame() {
		this.setVisible(false);
		if (resumeAction != null) {
			resumeAction.actionPerformed(null);
		}
	}

	/**
	 * Paints a semi-transparent black background over the entire panel area.
	 *
	 * @param g The Graphics object used for drawing.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 0, 0, 255));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
