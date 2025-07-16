import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
    JTextField nameField;
    JButton startButton;

    public LoginFrame() {
        setTitle("Quiz Application - Login");
        setSize(500, 250);
        setLocationRelativeTo(null); // center on screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel titleLabel = new JLabel("Welcome to Java Quiz!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(300, 30));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));

        startButton = new JButton("Start Quiz");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(30, 144, 255));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMargin(new Insets(10, 20, 10, 20));
        startButton.addActionListener(this);

        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(startButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        if (!name.isEmpty()) {
            new QuizFrame(name);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter your name");
        }
    }
}
