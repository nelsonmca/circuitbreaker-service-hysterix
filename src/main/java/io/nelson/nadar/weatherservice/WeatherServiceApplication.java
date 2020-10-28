package io.nelson.nadar.weatherservice;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class WeatherServiceApplication {
	
	String[] weather =  new String[] {"sunny","rainy","windy","cloudy"};

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
	
	@GetMapping("/weather")
	public String getWeather() {
		return weather[ThreadLocalRandom.current().nextInt(0, 4)];
	}

}
