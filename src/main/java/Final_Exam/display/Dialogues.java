package Final_Exam.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A custom modal dialog used to display sequential story messages to the user.
 * Clicking on the dialog advances the text to the next message.
 */
class Dialogues extends JDialog {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 200;

	private final String[] msgs;
	private int curIdx = 0;
	private JTextArea txtArea;

	private Runnable onFinish;

	/**
	 * Constructs a new Dialogues window.
	 *
	 * @param parentFrame The parent JFrame to position the dialog against.
	 * @param msgs        An array of strings representing the dialogue sequence.
	 * @param onFinish    A Runnable to execute after the last message is dismissed.
	 */
	public Dialogues(JFrame parentFrame, String[] msgs, Runnable onFinish) {
		super(parentFrame, true);
		this.msgs = msgs;
		this.onFinish = onFinish;

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
			int y = 700;
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

	/**
	 * Advances the dialogue to the next message. If there are no more messages,
	 * the dialog is disposed and the onFinish callback is executed.
	 */
	private void nextMsg() {
		curIdx++;
		if (curIdx < msgs.length) {
			txtArea.setText(msgs[curIdx]);
		} else {
			dispose();
			if (onFinish != null) {
                		onFinish.run();
            		}
		}
	}
}
