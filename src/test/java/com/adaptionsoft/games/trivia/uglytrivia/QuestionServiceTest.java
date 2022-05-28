package com.adaptionsoft.games.trivia.uglytrivia;

import com.adaptionsoft.games.uglytrivia.InvalidCategoryException;
import com.adaptionsoft.games.uglytrivia.QuestionService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {

    @Test
    void categoriesReturnSameCategoriesOfConstructor() {
        List<String> categories = Arrays.asList("Science", "Pop", "Math");

        QuestionService questionService = new QuestionService(categories);

        assertEquals(categories, questionService.categories());
    }

    @Test
    void questionsReturnSomeQuestionsOfACategory() throws InvalidCategoryException {
        List<String> categories = Arrays.asList("Biology", "History");

        QuestionService questionService = new QuestionService(categories);

        assertNotEquals(0, questionService.questions("Biology").size());
    }

    @Test
    void questionsReturnAnExceptionWenCallingAnUnexistantCategory() {
        List<String> categories = Arrays.asList("Biology", "History");

        QuestionService questionService = new QuestionService(categories);

        assertThrows(InvalidCategoryException.class, () -> questionService.questions("Chemistry"));
    }

    @Test
    void questionsReturnAllQuestionsOfACategory() throws InvalidCategoryException {
        List<String> categories = Arrays.asList("Biology", "History");

        QuestionService questionService = new QuestionService(categories, 28);

        assertEquals(28, questionService.questions("Biology").size());
    }

    @Test
    void getQuestionReturnAQuestion() {
        List<String> categories = Arrays.asList("Biology", "History");

        QuestionService questionService = new QuestionService(categories, 15);

        assertInstanceOf(String.class, questionService.getQuestion("History"));
    }
}
