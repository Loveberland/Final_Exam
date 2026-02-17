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

	public static JPanel createGamePanel() {
		JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));

		gameContentPanel = new JPanel();
		gameContentPanel.setLayout(null);
		gameContentPanel.setBackground(Color.WHITE);
		gameContentPanel.setBounds(0, 0, 1280, 960);

		pauseMenu = new PauseSystem(1280, 960, e -> {
			System.out.println("Game Resume");
		});

		layeredPane.add(gameContentPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(pauseMenu, JLayeredPane.PALETTE_LAYER);

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
		String[] story = {
			"ในวันเปิดภาคเรียน นักศึกษาหนุ่มคนหนึ่งก้าวเข้าสู่มหาวิทยาลัยชั้นนำของประเทศ สถานที่ซึ่งขึ้นชื่อว่า \"สร้างอัจฉริยะ\" และ \"กลืนกินคนอ่อนแอ\"\n" +
			"ไปพร้อมกัน เขาเลือกสาขาวิชาที่ไม่มีอยู่ในหลักสูตรทั่วไป สาขาที่ถูกระบุไว้เพียงว่า “สาขาวิชาพิเศษ” โดยไม่มีคำอธิบายใดเพิ่มเติม",
			"ทันทีที่ประตูมหาวิทยาลัยปิดลง ม่านหมอกพิษสีหม่นก็แผ่ ขยายออกมา กลืนกินโลกภายนอกจนไม่เหลือแม้แต่สัญญาณการสื่อสาร ผู้ที่พยายาม\n" +
			"หลบหนี ล้มตาย ผู้ที่พยายามต่อต้าน หายสาบสูญ และผู้ที่ยอมจำนน... ค่อย ๆ สูญเสียความเป็นมนุษย์ นักศึกษาค้นพบความจริงอันโหดร้าย",
			"ที่นี่ไม่ใช่สถานศึกษา แต่คือสนามทดลอง ความรู้ไม่ใช่เครื่องมือเพื่อพัฒนา แต่คือ อาวุธ เกรดไม่ใช่ตัวชี้วัดความ สามารถ แต่คือ เส้นแบ่งระหว่างชีวิตและความตาย",
			"เหนือมหาวิทยาลัยแห่งนี้ มี \"ผู้ปกครอง\" ปกครองอยู่ แต่ละคนครอบครองศาสตร์ ต้องห้าม แข็งแกร่งเกินกว่านักศึกษาจะต่อต้านได้ พวกเขา" +
			"ควบคุมหลักสูตร บิดเบือนความ จริง และคัดเลือกเฉพาะผู้ที่ \"เหมาะสมจะรอด\"",
			"ท่ามกลางความสิ้นหวัง มีตำนานต้องห้ามถูกกระซิบต่อกันในหมู่นักศึกษาเงามืด \"หากผู้ใดมีจิตใจที่ไม่แตกสลาย มีสติปัญญาที่ไม่ยอมศิโรราบ" +
			"และสามารถโค่นล้มผู้ ปกครองทั้งหมดลงได้ ม่านหมอกจะจางหาย และประตูสู่โลกภายนอกจะเปิดอีกครั้ง\""
		};

		panel.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorAdded(AncestorEvent event) {
				Window window = SwingUtilities.getWindowAncestor(panel);
				if (window instanceof JFrame) {
					JFrame parentFrame = (JFrame) window;

					SwingUtilities.invokeLater(() -> {
						if (!pauseMenu.isVisible()) {
							Dialogues intro = new Dialogues(parentFrame, story, () -> {
								JPanel heroTalkPanel = HeroTalk.createGamePanel();
								parentFrame.setContentPane(heroTalkPanel);
								parentFrame.revalidate(); parentFrame.repaint();
								heroTalkPanel.requestFocusInWindow();
							});
							intro.setVisible(true);
						}
					});
				}

				panel.removeAncestorListener(this);
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {}

			public void ancestorMoved(AncestorEvent event) {}

		});
	}
}
