package com.esv.service;

import com.esv.objects.Quest;
import com.esv.repository.QuestRepository;

import java.util.Map;

public class QuestService {
    private final Map<String, Quest> quests;
    public QuestService() {
        QuestRepository questRepository = new QuestRepository();
        this.quests = questRepository.getQuests();
    }
    public Map<String, Quest> getQuests() {
        return quests;
    }
}
