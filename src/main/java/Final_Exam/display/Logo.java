package Final_Exam.display;

import Final_Exam.display.ImgRes;
import Final_Exam.utils.ErrHandle;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Logo {
	private JLabel gameNameLabel;

	private void createLogo() {
		try {
			ImageIcon img = new ImageIcon(ImgRes.LOGO);
			gameNameLabel = new JLabel(img);
			gameNameLabel.setHorizontalAlignment(JLabel.CENTER);
			gameNameLabel.setPreferredSize(new Dimension(800, 300));
		} catch (Exception e) {
			ErrHandle.imgErr(e);
		}
	}

	public static JLabel getLogo() {
		Logo instance = new Logo();
		instance.createLogo();
		return instance.gameNameLabel;
	}
}
