package Final_Exam.display;

import Final_Exam.display.ImgRes;
import Final_Exam.enums.ImagePath;
import Final_Exam.utils.ErrHandle;
import javax.swing.*;
import java.awt.*;

/**
 * Component for displaying the game logo.
 */
public class Logo {

	// Constants for Logo Dimensions
	private static final int LOGO_WIDTH = 800;
	private static final int LOGO_HEIGHT = 300;

	// Private constructor since this is a utility/factory class now
	private Logo() {
	}

	/**
	 * Creates and returns a JLabel containing the game logo.
	 *
	 * @return The JLabel with the logo, or an empty label if loading fails.
	 */
	public static JLabel createLogoLabel() {
		JLabel logoLabel = new JLabel();
		try {
			// Get path from Enum via ImgRes (or directly from Enum)
			String path = ImgRes.getPath(ImagePath.LOGO);
			ImageIcon img = new ImageIcon(path);

			logoLabel.setIcon(img);
			logoLabel.setHorizontalAlignment(JLabel.CENTER);
			logoLabel.setPreferredSize(new Dimension(LOGO_WIDTH, LOGO_HEIGHT));

		} catch (Exception e) {
			ErrHandle.handleImageLoadingError(e);
			logoLabel.setText("Final Exam"); // Fallback text
		}
		return logoLabel;
	}
}
