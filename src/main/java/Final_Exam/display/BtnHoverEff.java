package Final_Exam.display;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class BtnHoverEff {
	public static MouseAdapter createHoverEff(JButton btn, ImageIcon normal, ImageIcon hover) {
		MouseAdapter hoverListener = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(hover);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(normal);
			}
		};
		return hoverListener;
	}

	public static void applyHoverEff(JButton btn, ImageIcon normal, ImageIcon hover) {
		btn.addMouseListener(createHoverEff(btn, normal, hover));
	}
}
