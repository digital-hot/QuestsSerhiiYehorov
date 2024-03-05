package com.esv.controllers;

import com.esv.objects.Quest;
import com.esv.service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "start", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Створення нової сесії
        HttpSession currentSession = req.getSession();
        QuestService questService = new QuestService();
        Map<String, Quest> quests = questService.getQuests();
        currentSession.setAttribute("quests",quests);
        currentSession.setAttribute("play",false);
        currentSession.setAttribute("result","");
        // Перенаправлення запиту на сторінку index.jsp через сервер
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
