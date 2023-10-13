package com.ingesoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BicicletasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicicletasApplication.class, args);
	}

    @Override
    public String toString() {
        return "BicicletasApplication []";
    }

}