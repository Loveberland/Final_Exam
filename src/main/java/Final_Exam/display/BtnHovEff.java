package Final_Exam.display;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Utility class for adding hover effects to buttons.
 */
public class BtnHovEff {

	// Private constructor to prevent instantiation
	private BtnHovEff() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	/**
	 * Applies a hover effect to a JButton by switching icons on mouse events.
	 *
	 * @param btn        The JButton to modify.
	 * @param normalIcon The icon to display when the mouse is not over the button.
	 * @param hoverIcon  The icon to display when the mouse is over the button.
	 */
	public static void applyHoverEffect(JButton btn, ImageIcon normalIcon, ImageIcon hoverIcon) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(hoverIcon);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(normalIcon);
			}
		});
	}
}
