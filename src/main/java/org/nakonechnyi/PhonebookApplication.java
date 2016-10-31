package org.nakonechnyi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class PhonebookApplication {
	@Value( "$")

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}
}
