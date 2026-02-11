package Final_Exam.utils;

/**
 * Utility class for handling errors in the application.
 */
public class ErrHandle {

	// Private constructor to prevent instantiation
	private ErrHandle() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	/**
	 * Handles exceptions related to image loading.
	 *
	 * @param e The exception that occurred.
	 */
	public static void handleImageLoadingError(Exception e) {
		System.err.println("[ERROR] Failed to load image resource: " + e.getMessage());
		e.printStackTrace();
	}
}
