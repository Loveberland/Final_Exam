package Final_Exam.display;

public class Question {

    private String questionHtml;
    private String correctAnswer;

    public Question(String questionHtml, String correctAnswer) {
        this.questionHtml = questionHtml;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionHtml() {
        return questionHtml;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}