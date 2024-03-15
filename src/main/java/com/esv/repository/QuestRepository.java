package com.esv.repository;

import com.esv.objects.Quest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class QuestRepository {
    private final Map<String , Quest> quests;
    //private static final Logger logger = LogManager.getLogger(QuestRepository.class);
    public QuestRepository() {
        this.quests = loadQuests();
    }
    public Map<String, Quest> getQuests() {
        return quests;
    }
    private Map<String, Quest> loadQuests() {
        //logger.debug("Start loading quests from YAML file");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try (InputStream inputStream = getClass().getResourceAsStream("/quests.yaml")) {
            return mapper.readValue(inputStream,
                    mapper.getTypeFactory().constructMapType(Map.class, String.class, Quest.class));
        } catch (IOException e) {
            //logger.error("Error loading quests from YAML file", e);
            return new HashMap<>();
        }
    }
}
