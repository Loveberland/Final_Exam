package Final_Exam.display;

import javax.swing.*;
import java.awt.*;
import Final_Exam.enums.ImagePath;
import Final_Exam.display.ImgRes;
import Final_Exam.utils.ErrHandle;

class BackgroundPanel extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel(ImagePath imgPath) {
		try {
			this.backgroundImage = new ImageIcon(ImgRes.getPath(imgPath)).getImage();
		} catch (Exception e) {
			ErrHandle.handleImageLoadingError(e);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
