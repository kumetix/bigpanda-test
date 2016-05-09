package kmt.bigpanda.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import kmt.bigpanda.test.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by assafep on 08/05/16.
 */
@Component
@DependsOn("statsController")
public class InputReader {

    private StatsCollector statsCollector;

    @Autowired
    public InputReader(StatsCollector statsCollector) {
        this.statsCollector = statsCollector;
    }

    @PostConstruct void postConstruct() {
        Runnable task = this::read;
        new Thread(task).start();
    }

    public void read() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        for (;;) {
            try {
                System.out.print("pending input => ");
                String line = bufferedReader.readLine();
                System.out.print("processing " + line + " ...");
                ObjectMapper objectMapper = new ObjectMapper();
                Event event = objectMapper.readValue(line, Event.class);
                statsCollector.processEvent(event);
                System.out.println(" finished");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
