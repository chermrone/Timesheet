package tn.esprit.spring;

 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimesheetSpringBootCoreDataJpaMvcRest1Application {
	 
	public static void main(String[] args) {
		SpringApplication.run(TimesheetSpringBootCoreDataJpaMvcRest1Application.class, args);
		System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");

		
	}

}
