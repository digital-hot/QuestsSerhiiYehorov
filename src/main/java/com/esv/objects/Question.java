package com.esv.objects;

import java.util.Map;
public class Question {
    private String id;
    private String title;
    private boolean won;
    private Map<String, Decision> decisions;

    //private static final Logger logger = LogManager.getLogger(Question.class);

    public Question() {
    }

    public Question(String id, String title, boolean won, Map<String, Decision> decisions) {
        this.id = id;
        this.title = title;
        this.won = won;
        this.decisions = decisions;
        //logger.error("Start Question won "+won);
    }
    public Question(String id, String title, Map<String, Decision> decisions) {
        this(id, title, false, decisions);
//        if (decisions != null) {
//            this.won = decisions.values().stream()
//                    .allMatch(decision -> decision != null && decision.getNextQuestion() != null && decision.getNextQuestion().getDecisions() == null);
//        }

//        if(decisions != null) {
//            Boolean t = true;
//            for (Decision d : decisions.values()){
//                if (d.getNextQuestion() != null && d.getNextQuestion().getDecisions() != null){
//                    t = false;
//                }
//            }
//            this.won = t;
//        }



//        if(!decisions.isEmpty()){
//            //decisions.values().stream().iterator()
//            for (Decision d : decisions.values()){
//                if (d.getNextQuestion() != null && !d.getNextQuestion().decisions.isEmpty()){
//                    this.won = true;
//                }
//            }
//        }
        //logger.error("Start Question won "+won);

    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isWon() {
        return won;
    }

    public Map<String, Decision> getDecisions() {
        return decisions;
    }
}
