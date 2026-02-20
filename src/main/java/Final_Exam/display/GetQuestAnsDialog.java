package Final_Exam.display;

import Final_Exam.enums.ImagePath;
import javax.swing.*;
import java.awt.*;

public class GetQuestAnsDialog extends JDialog{
        private final int WIDTH = 500;
        private final int HEIGHT = 600;
        private JTextField inputField;

        public GetQuestAnsDialog(JFrame parentFrame, ImagePath imgPath, String correctAnswer) {
                super(parentFrame, "Answer the question...", true);
                setSize(WIDTH, HEIGHT);
                setLocationRelativeTo(parentFrame);
                setLayout(new BorderLayout());
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                // Question
                ImageIcon img = new ImageIcon(ImgRes.getPath(imgPath));
                JLabel imgLabel = new JLabel(img);
                imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                add(imgLabel, BorderLayout.CENTER);

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
                submitButton.addActionListener(e -> {
                        String userInput = inputField.getText().trim();
                        if (userInput.equalsIgnoreCase(correctAnswer)) {
                                System.out.println("Correct Answer!");
                        } else {
                                System.out.println("Wrong Answer!");
                        }
                        dispose();
                });
                bottomPanel.add(submitButton, BorderLayout.SOUTH);
                
                add(bottomPanel, BorderLayout.SOUTH);
        }
}
