package Final_Exam.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import Final_Exam.models.Boss;
import Final_Exam.models.Nisit;

public class GetQuestAnsDialog extends JDialog {
        private final int WIDTH = 500;
        private final int HEIGHT = 600;
        private JTextField inputField;

        // Time tracking variables
        private Timer timeoutTimer;
        private long startTime;
        private int remainingTime;
        private boolean isPaused = false;

        public GetQuestAnsDialog(JFrame parentFrame, String correctAnswer, JLabel questionLabel, Nisit hero, Boss san) {
                super(parentFrame, "Answer the question...", true);
                setSize(WIDTH, HEIGHT);
                setLocationRelativeTo(parentFrame);
                setLayout(new BorderLayout());
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                // --- 1. Initialize your PauseSystem (1280 x 960) ---
                PauseSystem pauseSystem = new PauseSystem(1280, 960, null);
                this.setGlassPane(pauseSystem);

                // Question Panel setup
                questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                JScrollPane scrollPane = new JScrollPane(questionLabel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                add(scrollPane, BorderLayout.CENTER);

                // Answer Panel setup
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

                // --- 2. Timer Setup ---
                Random randTime = new Random();
                remainingTime = randTime.nextInt((180000 - 60000) + 1) + 60000;

                timeoutTimer = new Timer(remainingTime, e -> {
                        System.out.println("Time's up!");
                        san.atk(hero);
                        WhenFight.updateHeroHp(hero.getHp());
                        WhenFight.updateBossHp(san.getHp());
                        System.out.println("Hero hp: " + hero.getHp());
                        System.out.println("San hp: " + san.getHp());
                        dispose();
                });
                timeoutTimer.setRepeats(false);

                // Start counting down immediately
                startTime = System.currentTimeMillis();
                timeoutTimer.start();

                // --- 3. Key Binding for 'ESC' to Pause/Resume ---
                KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
                this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "togglePause");
                this.getRootPane().getActionMap().put("togglePause", new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (!isPaused) {
                                        // STOP the clock and show pause screen
                                        long elapsed = System.currentTimeMillis() - startTime;
                                        remainingTime -= (int) elapsed;
                                        timeoutTimer.stop();

                                        pauseSystem.setVisible(true);
                                        isPaused = true;
                                        inputField.setEnabled(false); // Optional: prevent typing while paused
                                } else {
                                        // RESUME the clock and hide pause screen
                                        if (remainingTime > 0) {
                                                timeoutTimer.setInitialDelay(remainingTime);
                                                timeoutTimer.start();
                                                startTime = System.currentTimeMillis();
                                        }

                                        pauseSystem.setVisible(false);
                                        isPaused = false;
                                        inputField.setEnabled(true);
                                        inputField.requestFocus(); // Give focus back to input
                                }
                        }
                });

                // --- 4. Submit Logic ---
                submitButton.addActionListener(e -> {
                        timeoutTimer.stop(); // Stop timer when they answer
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