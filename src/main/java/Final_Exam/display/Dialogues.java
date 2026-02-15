package Final_Exam.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Dialogues extends JDialog{
	private static final int WIDTH = 500;
	private static final int HEIGHT = 200;

	private final String[] msgs;
	private int curIdx = 0;
	private JTextArea txtArea;

	public Dialogues(JFrame parentFrame, String[] msgs) {
		super(parentFrame, true);
		this.msgs = msgs;

		setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());

		JPanel contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

		txtArea = new JTextArea();
		txtArea.setText(msgs[0]);
		txtArea.setFont(new Font("Arial", Font.BOLD, 18));
		txtArea.setForeground(Color.WHITE);
		txtArea.setBackground(Color.BLACK);
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setEditable(false);
		txtArea.setFocusable(false);

		txtArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		contentPanel.add(txtArea, BorderLayout.CENTER);
		add(contentPanel);

		if (parentFrame != null) {
			int x = parentFrame.getX() + (parentFrame.getWidth() - WIDTH) / 2;
			int y = 800;
			setLocation(x, y);
		} else {
			setLocationRelativeTo(null);
		}

		MouseAdapter advClick = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextMsg();
			}
		};

		contentPanel.addMouseListener(advClick);
		txtArea.addMouseListener(advClick);
	}

	private void nextMsg() {
		curIdx++;
		if (curIdx < msgs.length) {
			txtArea.setText(msgs[curIdx]);
		} else {
			dispose();
		}
	}
}
