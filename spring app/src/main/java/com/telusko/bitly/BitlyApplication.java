package com.telusko.bitly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Assignment
// 1. Have a hashmap that maps original url to the short url. If the long url is already present in the hashmap,
// return the already existing short url for it
// 2. Have a set instead of list for urls
// 3. Convert this to spring boot MVC project - make UI as well.
// 4. use original url to generate short url, but skip the special characters in the long url

@SpringBootApplication
public class BitlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitlyApplication.class, args);

	}

}
