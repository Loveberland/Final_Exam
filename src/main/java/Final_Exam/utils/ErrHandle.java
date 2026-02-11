package Final_Exam.utils;

import java.io.IOException;

public class ErrHandle {
	public static void imgErr(Exception e) {
		System.out.println("Error to load image: " + e.getMessage());
	}
}
