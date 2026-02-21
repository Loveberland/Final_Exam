package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import Final_Exam.models.Boss;
import Final_Exam.models.Character;
import Final_Exam.models.Nisit;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;

public class Ending {
        private static JPanel gameContentPanel;
	private static JLayeredPane layeredPane;
        private static JLabel hero;
        private static JLabel boss;

        public Ending(Character ch, JFrame parentFrame) {
                JPanel ending = addComponent(ch);
                parentFrame.setContentPane(ending);
		parentFrame.revalidate(); parentFrame.repaint();
		ending.requestFocusInWindow();
        }

        private JPanel addComponent(Character ch) {
                JPanel mainWrapper = new JPanel(new BorderLayout());
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1280, 960));
                
                // Initialize the panel first
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

                if (ch instanceof Nisit) {
                        hero = ImgPanel.createImgLabel(ImagePath.HERO, 100, 300);
                        hero.setBounds(150, 200, 500, 400);
                        gameContentPanel.add(hero, BorderLayout.WEST);
                } else if (ch instanceof Boss) {
                        boss = ImgPanel.createImgLabel(ImagePath.SUN, 100, 300);
                        boss.setBounds(800, 200, 100, 400);
                        gameContentPanel.add(boss, BorderLayout.EAST);
                }

                layeredPane.add(gameContentPanel, JLayeredPane.DEFAULT_LAYER);
                setupStoryLogic(mainWrapper, ch);

		mainWrapper.add(layeredPane, BorderLayout.CENTER);
                return mainWrapper;
        }

        private void setupStoryLogic(JPanel panel, Character ch) {
                if (ch instanceof Nisit) {
                        String[] story = {
                                "This cruel selection system has come to an end. The dull, poisonous fog is beginning to fade…",
                                "The university gates are about to open once again—not just for those labeled as geniuses, but for everyone you once dismissed as weak."
                        };

                        panel.addAncestorListener(new AncestorListener() {
                                @Override
                                public void ancestorAdded(AncestorEvent event) {
                                        Window window = SwingUtilities.getWindowAncestor(panel);
                                        if (window instanceof JFrame) {
                                                JFrame parentFrame = (JFrame) window;

                                                SwingUtilities.invokeLater(() -> {
                                                                Dialogues intro = new Dialogues(parentFrame, story, () -> {
                                                                        endingPage();
                                                                });
                                                                intro.setVisible(true);
                                                });
                                        }

                                        panel.removeAncestorListener(this);
                                }

                                @Override
                                public void ancestorRemoved(AncestorEvent event) {}

                                public void ancestorMoved(AncestorEvent event) {}

                        });
                } else if (ch instanceof Boss) {
                        String[] story = {
                                "An unbreakable spirit? A mind that refuses to kneel? Hah… just fairy tales the weak make up to comfort themselves. They\'ll never shake the truth of this place.",
                                "This university is a furnace… and you\'re nothing but substandard ore."
                        };

                        panel.addAncestorListener(new AncestorListener() {
                                @Override
                                public void ancestorAdded(AncestorEvent event) {
                                        Window window = SwingUtilities.getWindowAncestor(panel);
                                        if (window instanceof JFrame) {
                                                JFrame parentFrame = (JFrame) window;

                                                SwingUtilities.invokeLater(() -> {
                                                                Dialogues intro = new Dialogues(parentFrame, story, () -> {
                                                                        endingPage();
                                                                });
                                                                intro.setVisible(true);
                                                });
                                        }

                                        panel.removeAncestorListener(this);
                                }

                                @Override
                                public void ancestorRemoved(AncestorEvent event) {}

                                public void ancestorMoved(AncestorEvent event) {}
                        });
                }
	}

        private void endingPage() {
                layeredPane.removeAll();

                JPanel centerPanel = new JPanel(new GridBagLayout());
                centerPanel.setBounds(0, 0, 1280, 960);
                centerPanel.setBackground(Color.BLACK);

                JLabel img = ImgPanel.createImgLabel(ImagePath.EASTEREGG, 654, 872);

                centerPanel.add(img);
                layeredPane.add(centerPanel, JLayeredPane.DEFAULT_LAYER);

                layeredPane.revalidate();
                layeredPane.repaint();
        }
} 
