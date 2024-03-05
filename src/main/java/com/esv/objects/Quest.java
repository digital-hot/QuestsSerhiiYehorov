package com.esv.objects;

public class Quest {
    private String id;
    private String title;
    private Question question;

    public Quest() {
    }

    public Quest(String id, String title, Question question) {
        this.id = id;
        this.title = title;
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }
}
