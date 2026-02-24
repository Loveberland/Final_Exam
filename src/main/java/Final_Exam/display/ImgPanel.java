package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import Final_Exam.utils.ErrHandle;
import javax.swing.*;
import java.awt.*;

/**
 * Component for displaying the game logo.
 */
public class ImgPanel {

	/**
	 * Creates and returns a JLabel containing the game logo.
	 *
	 * @return The JLabel with the logo, or an empty label if loading fails.
	 */
	public static JLabel createImgLabel(ImagePath img, int WIDTH, int HEIGHT) {
		JLabel logoLabel = new JLabel();
		try {
			// Get path from Enum via ImgRes (or directly from Enum)
			ImageIcon normalImg = new ImageIcon(ImgRes.getPath(img));

			logoLabel.setIcon(normalImg);
			logoLabel.setHorizontalAlignment(JLabel.CENTER);
			logoLabel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		} catch (Exception e) {
			ErrHandle.handleImageLoadingError(e);
			logoLabel.setText("Final Exam"); // Fallback text
		}
		return logoLabel;
	}
}
