# Java Quiz Application

A simple, interactive Quiz Application built with Java Swing. Users can log in with their name, answer multiple-choice questions, view their score, and review their answers at the end. Results are saved for future reference.

## Features
- User login with name
- Randomized multiple-choice questions (10 per quiz)
- Immediate score display after quiz
- Review of all questions with correct and user answers highlighted
- Results saved to a file (`results.txt`)
- Easy to add or modify questions via `questions.txt`

## Getting Started

### Prerequisites
- Java JDK 8 or higher

### Running the Application
1. **Compile all Java files:**
   ```sh
   javac *.java
   ```
2. **Run the application:**
   ```sh
   java Main
   ```

## File Descriptions
- `Main.java` - Entry point; launches the login window.
- `LoginFrame.java` - Handles user login (name input).
- `QuizFrame.java` - Main quiz interface; loads questions, handles answers, scoring, and result saving.
- `ReviewFrame.java` - Displays a review of all questions, showing correct and user-selected answers.
- `Question.java` - Model class for quiz questions.
- `questions.txt` - Stores all quiz questions and answers in a specific format (see below).
- `results.txt` - Appends each user's score and date after quiz completion.

## Question File Format (`questions.txt`)
Each question consists of 6 lines:
1. The question text
2. Option 1
3. Option 2
4. Option 3
5. Option 4
6. The number (1-4) of the correct option

**Example:**
```
Which language is used for Android app development?
Java
Python
C++
Ruby
1
```

## How It Works
1. User enters their name and starts the quiz.
2. 10 random questions are loaded from `questions.txt`.
3. User selects answers; score is calculated in real-time.
4. At the end, the score is shown and saved to `results.txt`.
5. User can review all questions, with correct and incorrect answers highlighted.

## Customization
- **Add/Edit Questions:**
  - Open `questions.txt` and follow the 6-line format for each question.
- **View Results:**
  - Open `results.txt` to see all past quiz attempts.

## License
This project is for educational purposes. Feel free to modify and use it as you wish.
