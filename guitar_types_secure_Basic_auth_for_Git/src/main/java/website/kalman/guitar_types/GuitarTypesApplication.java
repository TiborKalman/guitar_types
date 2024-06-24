package website.kalman.guitar_types;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages= {"website.kalman.guitar_types"})
@SpringBootApplication
public class GuitarTypesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitarTypesApplication.class, args);
	}

}
