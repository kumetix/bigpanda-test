package kmt.bigpanda.test.web;

import kmt.bigpanda.test.StatsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by assafep on 08/05/16.
 */
@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsCollector statsCollector;

    @RequestMapping(value = "/eventTypeCount/{eventType}", method = RequestMethod.GET)
    public int getEventTypeCount(@PathVariable("eventType") String eventType) {
        return statsCollector.getEventTypeCount(eventType);
    }

    @RequestMapping(value = "/wordCount/{word}", method = RequestMethod.GET)
    public int getWordCount(@PathVariable("word") String word) {
        return statsCollector.getWordCount(word);
    }

}
