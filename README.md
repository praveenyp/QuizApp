# 🚀 Java Quiz Application

> **A modern, interactive quiz app built with Java Swing**

---

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![License: MIT](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

---

## 🎬 Preview

<!--
Add a screenshot of the app window here
![App Screenshot](screenshots/quizapp.png)
-->

---

## ✨ Features

- 👤 **User Login** — Enter your name to personalize your quiz experience
- 🎲 **Randomized Questions** — 10 unique questions per session, shuffled every time
- 📝 **Multiple Choice** — Simple, clean interface for answering questions
- ⚡ **Instant Results** — See your score as soon as you finish
- 🔍 **Answer Review** — Review all questions with correct and your answers highlighted
- 💾 **Persistent Results** — All scores saved to `results.txt` for future reference
- 🛠️ **Easy Customization** — Add or edit questions in `questions.txt`

---

## 🚦 Quick Start

1. **Clone or Download** this repository
2. **Compile** all Java files:
   ```sh
   javac *.java
   ```
3. **Run** the application:
   ```sh
   java Main
   ```

---

## 🗂️ Project Structure

| File              | Purpose                                                      |
|-------------------|--------------------------------------------------------------|
| `Main.java`       | Entry point; launches the login window                       |
| `LoginFrame.java` | User login (name input)                                      |
| `QuizFrame.java`  | Main quiz interface; handles questions, answers, scoring     |
| `ReviewFrame.java`| Review of all questions and answers                          |
| `Question.java`   | Model class for quiz questions                               |
| `questions.txt`   | All quiz questions and answers (see format below)            |
| `results.txt`     | Appends each user's score and date after quiz completion     |

---

## 📄 Question File Format (`questions.txt`)
Each question = 6 lines:
1. Question text
2. Option 1
3. Option 2
4. Option 3
5. Option 4
6. Number (1-4) of the correct option

**Example:**
```
Which language is used for Android app development?
Java
Python
C++
Ruby
1
```

---

## 🧑‍💻 How It Works
1. Enter your name and start the quiz
2. 10 random questions are loaded from `questions.txt`
3. Select your answers; score is calculated instantly
4. View your score and a detailed review at the end
5. All results are saved in `results.txt`

---

## 🛠️ Customization
- **Add/Edit Questions:**
  - Open `questions.txt` and follow the 6-line format for each question
- **View Results:**
  - Open `results.txt` to see all past quiz attempts

---

## ❓ FAQ

**Q: Can I add more than 10 questions?**  
A: Yes! The app will randomly select 10 from however many you add to `questions.txt`.

**Q: How do I reset the results?**  
A: Simply delete or clear the `results.txt` file.

**Q: Can I change the look and feel?**  
A: Yes! Modify the Java Swing code in the `*Frame.java` files for custom themes.

---

## 📢 License

This project is for educational purposes. Feel free to modify and use it as you wish.
