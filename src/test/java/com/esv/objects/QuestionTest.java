package com.esv.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    private Question question;

    @BeforeEach
    public void setUp() {
        // Створюємо тестові дані для класу Question
        Map<String, Decision> decisions = new HashMap<>();
        Decision decision11 = new Decision("decision11", "Decision 11", null);
        Decision decision22 = new Decision("decision22", "Decision 22", null);
        decisions.put("decision11", decision11);
        decisions.put("decision22", decision22);
        Question nextQuestion = new Question("nextQuestion1", "Next Question", null);
        Map<String, Decision> decisions2 = new HashMap<>();
        // Додати рішення для тестування
        Decision decision1 = new Decision("decision1", "Decision 1", nextQuestion);
        Decision decision2 = new Decision("decision1", "Decision 1", nextQuestion);
        decisions2.put("decision1", decision1);
        decisions2.put("decision1", decision2);
        // Створити об'єкт Question для тестування
        question = new Question("question1", "Test Question", decisions2);
    }

    @Test
    public void testGetId() {
        assertEquals("question1", question.getId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Question", question.getTitle());
    }

    @Test
    public void testIsWon() {
        assertFalse(question.isWon()); // Перевірка, чи початково виграш не встановлено
    }

    @Test
    public void testGetDecisions() {
        assertNotNull(question.getDecisions()); // Перевірка, чи отримуємо колекцію рішень
        assertEquals(1, question.getDecisions().size()); // Перевірка кількості рішень
    }

}