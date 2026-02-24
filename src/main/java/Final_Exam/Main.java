package Final_Exam;

import Final_Exam.display.MainFrame;
import javax.swing.SwingUtilities;

/**
 * Main entry point for start program
 */
public class Main {
   	public static void main(String[] args) {
					// Use for run in safe thread
        	SwingUtilities.invokeLater(() -> {
            		MainFrame mainFrame = new MainFrame();
            		mainFrame.show();
        	});
    	}
}
