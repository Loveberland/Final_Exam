package Final_Exam.display;

import Final_Exam.enums.ImagePath;

/**
 * Utility class for managing image resources.
 * This class primarily serves as a centralized point for accessing image paths
 * defined in the ImagePath enum.
 */
public class ImgRes {

	// Private constructor to prevent instantiation
	private ImgRes() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	public static String getPath(ImagePath imagePath) {
		return imagePath.getPath();
	}
}
