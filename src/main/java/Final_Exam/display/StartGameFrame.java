package Final_Exam.display;

import Final_Exam.display.BackgroundPanel;
import Final_Exam.enums.ImagePath;
import javax.swing.*;
import java.awt.*;

public class StartGameFrame {
	public static JPanel createGamePanel() {
		JPanel panel = new BackgroundPanel(ImagePath.EASTEREGG);
		panel.setLayout(new BorderLayout());
		return panel;
	}
}
