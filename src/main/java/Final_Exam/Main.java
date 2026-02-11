package Final_Exam;

import Final_Exam.display.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
   	public static void main(String[] args) {
        	SwingUtilities.invokeLater(() -> {
            		MainFrame mainFrame = new MainFrame();
            		mainFrame.show();
        	});
    	}
}
