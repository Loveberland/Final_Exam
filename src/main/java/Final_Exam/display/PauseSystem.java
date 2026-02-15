package Final_Exam.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class PauseSystem extends JPanel {
	private final ActionListener resumeAction;

	public PauseSystem(int wid, int hei, ActionListener resumeAction) {
		this.resumeAction = resumeAction;
		this.setBounds(0, 0, wid, hei);
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(Box.createVerticalGlue());

		JLabel pauseLabel = new JLabel("GAME PAUSE");
		pauseLabel.setFont(new Font("Arial", Font.BOLD, 60));
		pauseLabel.setForeground(Color.WHITE);
		pauseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(pauseLabel);

		JButton resumeBtn = createSimpleBtn("RESUME");
		resumeBtn.addActionListener(e -> resumeGame());
		this.add(resumeBtn);

		this.add(Box.createVerticalGlue());

		this.setVisible(false);
	}

	private JButton createSimpleBtn(String txt) {
		JButton btn = new JButton(txt);
		btn.setFont(new Font("Arial", Font.BOLD, 30));
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn.setFocusPainted(false);
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		btn.setPreferredSize(new Dimension(200, 60));
		btn.setMaximumSize(new Dimension(200, 60));
		return btn;
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
