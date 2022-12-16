package pfig3.bookingg3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BookingG3Application {

	public static void main(String[] args) {
		SpringApplication.run(BookingG3Application.class, args);
	}

}
