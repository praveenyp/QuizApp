public class Question {
    String question, option1, option2, option3, option4;
    int correctAnswer;

    public Question(String question, String o1, String o2, String o3, String o4, int correct) {
        this.question = question;
        this.option1 = o1;
        this.option2 = o2;
        this.option3 = o3;
        this.option4 = o4;
        this.correctAnswer = correct;
    }
}
