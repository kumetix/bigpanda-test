package kmt.bigpanda.test;

import kmt.bigpanda.test.domain.Event;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by assafep on 08/05/16.
 */
@Component
public class StatsCollector {

    private Map<String,Integer> eventTypeCount = new HashMap<>();
    private Map<String,Integer> wordCount = new HashMap<>();

    public void processEvent(Event event) {
        eventTypeCount.put(event.getEventType(), eventTypeCount.getOrDefault(event.getEventType(), 0) + 1);
        wordCount.put(event.getData(), wordCount.getOrDefault(event.getData(), 0) + 1);
    }

    public int getEventTypeCount(String eventType) {
        return eventTypeCount.getOrDefault(eventType, 0);
    }

    public int getWordCount(String word) {
        return wordCount.getOrDefault(word, 0);
    }
}
