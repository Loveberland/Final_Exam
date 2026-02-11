package Final_Exam.display;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnHovEff {
	public static void applyHovEff(JButton btn, ImageIcon nor, ImageIcon hov) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(hov);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(nor);
			}
		});
	}
}
