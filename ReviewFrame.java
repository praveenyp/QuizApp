import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ReviewFrame extends JFrame {
    public ReviewFrame(ArrayList<Question> questions, ArrayList<Integer> userAnswers, String username, int score) {
        setTitle("Answer Review - " + username);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Answer Review", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel reviewPanel = new JPanel();
        reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.Y_AXIS));
        reviewPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(reviewPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            int userAns = userAnswers.get(i);
            int correctAns = q.correctAnswer;

            JPanel questionBlock = new JPanel();
            questionBlock.setLayout(new BoxLayout(questionBlock, BoxLayout.Y_AXIS));
            questionBlock.setBackground(Color.WHITE);
            questionBlock.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                    BorderFactory.createEmptyBorder(10, 15, 10, 15)
            ));

            JLabel qLabel = new JLabel((i + 1) + ". " + q.question);
            qLabel.setFont(new Font("Arial", Font.BOLD, 16));
            questionBlock.add(qLabel);

            String[] options = { q.option1, q.option2, q.option3, q.option4 };

            for (int j = 0; j < 4; j++) {
                JLabel optLabel = new JLabel("  " + (j + 1) + ") " + options[j]);
                optLabel.setFont(new Font("Arial", Font.PLAIN, 15));

                if (j + 1 == correctAns) {
                    optLabel.setForeground(new Color(0, 128, 0)); // green
                }
                if (j + 1 == userAns && userAns != correctAns) {
                    optLabel.setForeground(Color.RED); // red
                }

                questionBlock.add(optLabel);
            }

            reviewPanel.add(questionBlock);
            reviewPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBackground(Color.DARK_GRAY);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.addActionListener(e -> System.exit(0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(closeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
