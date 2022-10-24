package org.edu.farhadi.simplerelational.database;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.Objects;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class SimpleRelationalDatabaseApplication {
	private final Environment environment;
	public static void main(String[] args) {
		SpringApplication.run(SimpleRelationalDatabaseApplication.class, args);
	}

//	@Profile("dev")
//	@SneakyThrows
//	@PostConstruct
//	private void postConstruct() {
//		String protocol = "https";
//		if (Objects.isNull(environment.getProperty("server.ssl.key-store"))) {
//			protocol = "http";
//		}
//		String port = environment.getProperty("server.port");
//		String appName = environment.getProperty("spring.application.name");
//		String url = protocol.concat("://localhost:").concat(port).concat("/swagger-ui.html");
//
//		log.info("\n----------------------------------------------------------\n\t"
//						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}\n\t"
//						+ "External: \t{}://{}:{}\n\t"
//						+ "Profile(s): \t{}\n----------------------------------------------------------",
//				appName, url, protocol,
//				InetAddress.getLocalHost().getHostAddress(), port, environment.getActiveProfiles());
//
//	}
}
