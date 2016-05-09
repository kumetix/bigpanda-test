package kmt.bigpanda.test;

import kmt.bigpanda.test.domain.Event;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by assafep on 09/05/16.
 */
public class StatsCollectorTest {

    @Test
    public void verifyStatsCollectedCorrectly() {
        StatsCollector stats = new StatsCollector();
        stats.processEvent(createValidEvent());
        Assert.assertEquals(1, stats.getEventTypeCount("foo"));
        Assert.assertEquals(1, stats.getWordCount("shoosh"));
    }

    private Event createValidEvent() {
        return new Event("foo", "shoosh", 1L);
    }
}
