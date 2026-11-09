package book.soap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import book.soap.service.BookSoapServiceImpl;
import jakarta.xml.ws.Endpoint;

@SpringBootApplication
public class BookSoapApp {

	public static void main(String[] args) {
		SpringApplication.run(BookSoapApp.class, args);
	}

	@Bean(destroyMethod = "stop")
	public Endpoint endpoint(BookSoapServiceImpl bookSoapService,
			@Value("${soap.address}") String address) {
		return Endpoint.publish(address, bookSoapService);
	}

}
