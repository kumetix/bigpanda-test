package kmt.bigpanda.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import kmt.bigpanda.test.domain.Event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class BigpandaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigpandaTestApplication.class, args);
	}
}
