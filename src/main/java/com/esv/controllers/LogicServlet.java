package com.esv.controllers;

import com.esv.objects.Decision;
import com.esv.objects.Quest;
import com.esv.objects.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "quest",value="/quest")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession currentSession = req.getSession();

        if (!(boolean) currentSession.getAttribute("play")) {
            currentSession.setAttribute("play",true);
            String questId = req.getParameter("questId");
            Map<String , Quest>  quests= extractQuests(currentSession, resp);
            Quest quest = quests.get(questId);
            currentSession.setAttribute("question",quest.getQuestion());
            getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
            return;
        }

        Question question = extractQuestion(currentSession, resp);
        Map<String, Decision> decisions = question.getDecisions();

        if(decisions == null){
            req.getSession().invalidate();
            resp.sendRedirect("/start");
            return;
        }

        Decision decision = decisions.get(req.getParameter("decisionId"));
        if (!Objects.isNull(decision)){
            Question nextQuestion = decision.getNextQuestion();
            if (Objects.isNull(nextQuestion.getDecisions())){
                currentSession.setAttribute("question",nextQuestion);
                if(nextQuestion.isWon()){
                    currentSession.setAttribute("result","won");
                }else {
                    currentSession.setAttribute("result","lost");
                }
            }else{
                currentSession.setAttribute("question",nextQuestion);
            }
        }

        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }

    private Map<String, Quest> extractQuests(HttpSession currentSession, HttpServletResponse resp) throws IOException {
        Object questsAttribute = currentSession.getAttribute("quests");
        if (questsAttribute == null || !Map.class.isAssignableFrom(questsAttribute.getClass())) {
            currentSession.invalidate();
            resp.sendRedirect("/start");
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Map<String, Quest>) questsAttribute;
    }

    private Question extractQuestion(HttpSession currentSession, HttpServletResponse resp) throws IOException {
        Object questionAttribute = currentSession.getAttribute("question");
        if (questionAttribute == null || !Question.class.isAssignableFrom(questionAttribute.getClass())) {
            currentSession.invalidate();
            resp.sendRedirect("/start");
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Question) questionAttribute;
    }
}