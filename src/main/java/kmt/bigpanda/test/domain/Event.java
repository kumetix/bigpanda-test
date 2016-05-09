package kmt.bigpanda.test.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by assafep on 08/05/16.
 */
public class Event {
    private String eventType;
    private String data;
    private Long timestamp;

    public Event() {}

    public Event(String eventType, String data, Long timestamp) {
        this.eventType = eventType;
        this.data = data;
        this.timestamp = timestamp;
    }

    @JsonProperty("event_type")
    public String getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
