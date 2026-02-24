package Final_Exam.display;

import java.util.ArrayList;
import java.util.List;

import Final_Exam.enums.FirstQuestion;

/**
 * A utility class acting as a repository for all the questions available in the game.
 */
public class QuestionBank {

    /**
     * Retrieves a complete list of all algorithm identification questions 
     * defined in the FirstQuestion enum, mapping them to their correct string answers.
     *
     * @return A List of Question objects ready to be used in the game.
     */
    public static List<Question> getAllQuestions() {

        List<Question> list = new ArrayList<>();

        list.add(new Question(
                FirstQuestion.DFS_Q.getQuestionHtml(),
                "depth_first_search"
        ));

        list.add(new Question(
                FirstQuestion.BINARY_SEARCH_Q.getQuestionHtml(),
                "binary_search"
        ));

        list.add(new Question(
                FirstQuestion.INSERTION_SORT_Q.getQuestionHtml(),
                "insertion_sort"
        ));

        list.add(new Question(
                FirstQuestion.MERGE_SORT_Q.getQuestionHtml(),
                "merge_sort"
        ));

        list.add(new Question(
                FirstQuestion.SELECTION_SORT.getQuestionHtml(),
                "selection_sort"
        ));

        list.add(new Question(
                FirstQuestion.BUBBLE_SORT.getQuestionHtml(),
                "bubble_sort"
        ));

        list.add(new Question(
                FirstQuestion.QUICK_SORT.getQuestionHtml(),
                "quick_sort"
        ));

        list.add(new Question(
                FirstQuestion.BREADTH_FIRST_SEARCH.getQuestionHtml(),
                "breadth_first_search"
        ));

        list.add(new Question(
                FirstQuestion.LINEAR_SEARCH.getQuestionHtml(),
                "linear_search"
        ));

        return list;
    }
}
