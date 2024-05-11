package Harsha.Project1;

import Harsha.Project1.run.Health;
import Harsha.Project1.run.Location;
import Harsha.Project1.run.Run;
import Harsha.Project1.run.Taste;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Project1Application {

	private static final Logger log = LoggerFactory.getLogger(Project1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args ->{
			Run run = new Run(10,2, Health.Healthier, Taste.Special,Location.Native);
			log.info("Run"+run);
		};
	}

}
