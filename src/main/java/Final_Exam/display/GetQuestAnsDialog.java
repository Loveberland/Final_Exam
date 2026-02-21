package Final_Exam.display;

import javax.swing.*;
import java.awt.*;

import Final_Exam.models.Boss;
import Final_Exam.models.Nisit;

public class GetQuestAnsDialog extends JDialog{
        private final int WIDTH = 500;
        private final int HEIGHT = 600;
        private JTextField inputField;

        public GetQuestAnsDialog(JFrame parentFrame, String correctAnswer, JLabel questionLabel, Nisit hero, Boss san) {
                super(parentFrame, "Answer the question...", true);
                setSize(WIDTH, HEIGHT);
                setLocationRelativeTo(parentFrame);
                setLayout(new BorderLayout());
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                // Question
                questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                JScrollPane scrollPane = new JScrollPane(questionLabel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adds a little breathing room
                add(scrollPane, BorderLayout.CENTER);

                // Answer
                JPanel bottomPanel = new JPanel();
                bottomPanel.setLayout(new BorderLayout(10, 10));
                bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                
                JLabel instructionLabel = new JLabel("Type your answer...", SwingConstants.CENTER);
                bottomPanel.add(instructionLabel, BorderLayout.NORTH);

                inputField = new JTextField();
                inputField.setFont(new Font("Arial", Font.PLAIN, 16));
                inputField.setMargin(new Insets(5, 5, 5, 5));
                bottomPanel.add(inputField, BorderLayout.CENTER);

                JButton submitButton = new JButton("Submit");
                submitButton.setPreferredSize(new Dimension(100, 40));
               
		int timeLimit = 180000;
		Timer timeoutTimer = new Timer(timeLimit, e -> {
			System.out.println("Time's up!");	
			san.atk(hero);	
			WhenFight.updateHeroHp(hero.getHp());
    			WhenFight.updateBossHp(san.getHp());
    			System.out.println("Hero hp: " + hero.getHp());
    			System.out.println("San hp: " + san.getHp());
    			dispose();
		}); 
		timeoutTimer.setRepeats(false);
		timeoutTimer.start();
		submitButton.addActionListener(e -> {
                        String userInput = inputField.getText().trim();
                        if (userInput.toLowerCase().equalsIgnoreCase(correctAnswer)) {
                                hero.atk(san);
                        } else {
                                san.atk(hero);
                        }
                        WhenFight.updateHeroHp(hero.getHp());
                        WhenFight.updateBossHp(san.getHp());
                        System.out.println("Hero hp: " + hero.getHp());
                        System.out.println("San hp: " + san.getHp());
                        dispose();
                });
                bottomPanel.add(submitButton, BorderLayout.SOUTH);
                
                add(bottomPanel, BorderLayout.SOUTH);
        }
}
