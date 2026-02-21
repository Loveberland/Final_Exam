package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import Final_Exam.models.Boss;
import Final_Exam.models.Character;
import Final_Exam.models.Nisit;

import javax.swing.*;
import java.awt.*;

public class Ending {
        private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
        private static JLabel hero;
        private static JLabel boss;

        public Ending(Character ch, JFrame parentFrame) {
                addComponent();
                if (ch instanceof Nisit) {
                        hero = ImgPanel.createImgLabel(ImagePath.HERO, 100, 300);
                        hero.setBounds(150, 200, 500, 400);
                        gameContentPanel.add(hero, BorderLayout.WEST);
                } else {
                        boss = ImgPanel.createImgLabel(ImagePath.SUN, 100, 300);
                        boss.setBounds(800, 200, 100, 400);
                        gameContentPanel.add(boss, BorderLayout.EAST);
                }
        }

        private void addComponent() {
                JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));
                gameContentPanel = new JPanel() {
			private Image backgroundImage = new ImageIcon(ImgRes.getPath(ImagePath.FIGHT_BG)).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		gameContentPanel.setLayout(null);
		gameContentPanel.setBounds(-1, 0, 1280, 960);

                layeredPane.add(gameContentPanel, JLayeredPane.DEFAULT_LAYER);

		mainWrapper.add(layeredPane, BorderLayout.CENTER);
        }
} 
