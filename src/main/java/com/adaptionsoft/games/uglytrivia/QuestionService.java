package com.adaptionsoft.games.uglytrivia;

import java.util.*;

public class QuestionService {

    private final List<String> categories;
    private final int numQuestionsPerCategory;
    Map<String, LinkedList<String>> categoryQuestions = new HashMap<>();

    public QuestionService(List<String> categories) {
        this(categories, 50);
    }

    public QuestionService(List<String> categories, int numQuestionsPerCategory) {
        this.categories = categories;
        this.numQuestionsPerCategory = numQuestionsPerCategory;
        generateQuestions();
    }

    public List<String> categories() {
        return categories;
    }

    public List<String> questions(String category) throws InvalidCategoryException {
        if (!categories.contains(category)) {
            throw new InvalidCategoryException();
        }
        return categoryQuestions.get(category);
    }

    private void generateQuestions() {
        for (String category: categories) {
            LinkedList<String> questions = new LinkedList<>();
            for (int i = 0; i < numQuestionsPerCategory; i++) {
                questions.addLast(createQuestion(category, i));
            }
            categoryQuestions.put(category, questions);
        }
    }

    public String getQuestion(String category) {
        return categoryQuestions.get(category).removeFirst();
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }
}
