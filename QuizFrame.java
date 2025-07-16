import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;

public class QuizFrame extends JFrame implements ActionListener {
    ArrayList<Question> questions = new ArrayList<>();
    ArrayList<Integer> userAnswers = new ArrayList<>();
    int index = 0, score = 0;
    String username;

    JLabel qLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup group = new ButtonGroup();
    JButton nextButton;

    public QuizFrame(String name) {
        this.username = name;
        loadQuestions();

        setTitle("Quiz for " + username);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // Question label
        qLabel = new JLabel();
        qLabel.setFont(new Font("Arial", Font.BOLD, 20));
        qLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        add(qLabel, BorderLayout.NORTH);

        // Options panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        centerPanel.setBackground(Color.WHITE);

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Arial", Font.PLAIN, 16));
            options[i].setBackground(Color.WHITE);
            group.add(options[i]);
            centerPanel.add(options[i]);
        }

        add(centerPanel, BorderLayout.CENTER);

        // Next button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(new Color(46, 204, 113));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setMargin(new Insets(10, 20, 10, 20));
        nextButton.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.WHITE);
        southPanel.add(nextButton);
        add(southPanel, BorderLayout.SOUTH);

        loadQuestion(index);
        setVisible(true);
    }

    public void loadQuestions() {
        ArrayList<Question> allQuestions = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String q = line;
                String o1 = br.readLine();
                String o2 = br.readLine();
                String o3 = br.readLine();
                String o4 = br.readLine();
                int correct = Integer.parseInt(br.readLine());
                allQuestions.add(new Question(q, o1, o2, o3, o4, correct));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading questions: " + e.getMessage());
            System.exit(1);
        }
    
        // 🎲 Shuffle and pick 10
        Collections.shuffle(allQuestions);
        questions = new ArrayList<>(allQuestions.subList(0, Math.min(10, allQuestions.size())));
    }
    

    public void loadQuestion(int i) {
        Question q = questions.get(i);
        qLabel.setText((i + 1) + ". " + q.question);
        options[0].setText(q.option1);
        options[1].setText(q.option2);
        options[2].setText(q.option3);
        options[3].setText(q.option4);
        group.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selected = i + 1;
            }
        }

        userAnswers.add(selected);

        if (selected == questions.get(index).correctAnswer) {
            score++;
        }

        index++;

        if (index < questions.size()) {
            loadQuestion(index);
        } else {
            JOptionPane.showMessageDialog(this,
                username + ", Quiz finished!\nYour score: " + score + "/" + questions.size());
            saveResultToFile();
            dispose();
            new ReviewFrame(questions, userAnswers, username, score);
        }
    }

    public void saveResultToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("results.txt", true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            String resultLine = "Name: " + username + " | Score: " + score + "/" + questions.size() +
                                " | Date: " + dtf.format(now) + "\n";

            bw.write(resultLine);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving result: " + e.getMessage());
        }
    }
}
