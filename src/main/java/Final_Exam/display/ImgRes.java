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
	
	/**
	 * Retrieves the relative file path as a string for a given ImagePath enum.
	 *
	 * @param imagePath The enum constant representing the desired image.
	 * @return A string representation of the file path.
	 */
	public static String getPath(ImagePath imagePath) {
		return imagePath.getPath();
	}
}
