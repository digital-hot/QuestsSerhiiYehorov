package com.esv.objects;

public class Decision {
    private  String id;
    private  String title;
    private Question nextQuestion;

    public Decision() {
    }

    public Decision(String id, String title, Question nextQuestion) {
        this.id = id;
        this.title = title;
        this.nextQuestion = nextQuestion;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }
}
