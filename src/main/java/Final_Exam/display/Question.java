package Final_Exam.display;

/**
 * Represents a single question used in the game's battle system.
 * It stores the HTML-formatted question content and its corresponding correct answer.
 */
public class Question {

    private String questionHtml;
    private String correctAnswer;

    /**
     * Constructs a new Question with the specified HTML content and correct answer.
     *
     * @param questionHtml  The HTML string representing the question.
     * @param correctAnswer The correct answer string.
     */
    public Question(String questionHtml, String correctAnswer) {
        this.questionHtml = questionHtml;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Retrieves the HTML-formatted string for the question.
     *
     * @return The question's HTML string.
     */
    public String getQuestionHtml() {
        return questionHtml;
    }

    /**
     * Retrieves the correct answer for the question.
     *
     * @return The correct answer string.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
