package br.com.msansone.apistockscontrol;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class ApiStockscontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStockscontrolApplication.class, args);
	}

}
