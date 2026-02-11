package Final_Exam.display;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
	private JFrame frame;

	public MainFrame() {
		initialize();
		getLogo();
		getMenu();
	}

	public void show() {
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Final Exam");
		frame.setSize(1280, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	private void getLogo() {
		frame.add(Logo.getLogo(), BorderLayout.NORTH);
	}

	private void getMenu() {
		frame.add(GetBtn.getMenuPanel(), BorderLayout.CENTER);
	}

	private void getSetting() {
		frame.add(GetBtn.getSettingPanel(), BorderLayout.CENTER);
	}
}
